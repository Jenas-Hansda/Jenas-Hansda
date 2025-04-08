import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        // If the lengths of the words are different, return false
        if (word1.length() != word2.length()) {
            return false;
        }
        
        // Create frequency maps for both words
        Map<Character, Integer> counts1 = getFrequencyMap(word1);
        Map<Character, Integer> counts2 = getFrequencyMap(word2);
        
        // Check if the unique characters are the same
        if (!counts1.keySet().equals(counts2.keySet())) {
            return false;
        }
        
        // Check if the frequency counts are the same, sorted
        List<Integer> values1 = new ArrayList<>(counts1.values());
        List<Integer> values2 = new ArrayList<>(counts2.values());
        Collections.sort(values1);
        Collections.sort(values2);
        
        return values1.equals(values2);
    }
    
    // Helper method to generate frequency map for a string
    private Map<Character, Integer> getFrequencyMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
