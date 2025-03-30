class reverseVowels {
    public String ReverseVowels(String s) {
        // Convert string to character array for easier manipulation
        char[] chars = s.toCharArray();
        
        // Set of vowels to check against
        String vowels = "aeiouAEIOU";
        
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            // Move left pointer to the next vowel
            if (vowels.indexOf(chars[left]) == -1) {
                left++;
            }
            // Move right pointer to the previous vowel
            else if (vowels.indexOf(chars[right]) == -1) {
                right--;
            }
            // Swap the vowels
            else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        
        // Convert character array back to string and return the result
        return new String(chars);
    }
}
