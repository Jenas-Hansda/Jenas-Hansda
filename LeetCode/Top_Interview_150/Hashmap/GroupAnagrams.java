package Top_Interview_150.Hashmap;
import java.util.*;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int count : freq) {
                sb.append(count).append("#");
            }
            String key = sb.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}