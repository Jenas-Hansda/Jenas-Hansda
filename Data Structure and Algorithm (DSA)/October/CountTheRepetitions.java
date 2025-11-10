class CountTheRepetitions {
    public boolean isConcatenated(String word, Set<String> st, Map<String, Boolean> map) {
        if (map.containsKey(word))
            return map.get(word);

        int l = word.length();
        for (int i = 1; i < l; i++) { // start from 1 — empty prefix not allowed
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (st.contains(prefix) &&
                (st.contains(suffix) || isConcatenated(suffix, st, map))) {
                map.put(word, true);
                return true;
            }
        }
        map.put(word, false);
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> st = new HashSet<>(Arrays.asList(words));
        Map<String, Boolean> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.length() == 0) continue;
            st.remove(word); // temporarily remove to prevent self-use
            if (isConcatenated(word, st, map))
                result.add(word);
            st.add(word); // restore after check
        }
        return result;
    }
}
