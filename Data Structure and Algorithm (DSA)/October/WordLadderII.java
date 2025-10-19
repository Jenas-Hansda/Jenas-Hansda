class WordLadderII{
    private Set<String> dict;
    private Map<String, List<String>> memo;

    private List<String> solve(String s) {
        if (s.isEmpty()) {
            return Arrays.asList("");
        }
        
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();
        for (int l = 1; l <= s.length(); l++) {
            String currWord = s.substring(0, l);
            if (dict.contains(currWord)) {
                String remainWord = s.substring(l);
                List<String> remainResult = solve(remainWord);
                for (String w : remainResult) {
                    String toAdd = currWord + (w.isEmpty() ? "" : " ") + w;
                    result.add(toAdd);
                }
            }
        }

        memo.put(s, result);
        return result;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        memo = new HashMap<>();

        return solve(s);
    }
}