class maximumNumber {
    public int maxVowels(String s, int k) {
        // Set of vowels for quick lookup
        String vowels = "aeiou";
        int curr = 0;
        
        // Initial window of size k
        for (int i = 0; i < k; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {  // Check if character is a vowel
                curr++;
            }
        }
        
        int maxVowels = curr;  // Initialize max_vowels after the first window
        
        // Sliding window approach
        for (int i = k; i < s.length(); i++) {
            // Add the new character to the window
            if (vowels.indexOf(s.charAt(i)) != -1) {
                curr++;
            }
            
            // Remove the character that is sliding out of the window
            if (vowels.indexOf(s.charAt(i - k)) != -1) {
                curr--;
            }
            
            // Update maxVowels with the maximum count found so far
            maxVowels = Math.max(maxVowels, curr);
        }
        
        return maxVowels;
    }
}
