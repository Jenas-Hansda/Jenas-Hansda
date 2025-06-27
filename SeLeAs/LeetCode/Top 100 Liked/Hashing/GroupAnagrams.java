import java.util.*;

public class GroupAnagrams {
    

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Use a HashMap to store the frequency key and corresponding list of anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // Create a frequency array for 26 lowercase letters
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            // Convert the frequency array to a string key
            // This is similar to using tuple(freq) in Python
            StringBuilder sb = new StringBuilder();
            for (int count : freq) {
                sb.append(count).append("#"); // Use a separator to avoid ambiguity
            }
            String key = sb.toString();

            // Add the word to the map
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        // Return all grouped anagrams as a list of lists
        return new ArrayList<>(map.values());
    }
}

}
