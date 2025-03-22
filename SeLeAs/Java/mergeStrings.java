class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder merged = new StringBuilder();
        int len_w1 = word1.length();
        int len_w2 = word2.length();
        
        // Merge alternating characters
        while (i < len_w1 && j < len_w2) {
            merged.append(word1.charAt(i));
            merged.append(word2.charAt(j));
            i++;
            j++;
        }
        
        // Add remaining characters from word1, if any
        if (i < len_w1) {
            merged.append(word1.substring(i));
        }
        // Add remaining characters from word2, if any
        else {
            merged.append(word2.substring(j));
        }
        
        return merged.toString();
    }
}
