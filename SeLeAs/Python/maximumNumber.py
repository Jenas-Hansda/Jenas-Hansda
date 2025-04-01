class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        vowels = {'a', 'e', 'i', 'o', 'u'}
        curr = 0
        
        # Initial window of size k
        for i in range(k):
            if s[i] in vowels:
                curr += 1
        
        max_vowels = curr  # Initialize max_vowels after the first window
        
        # Sliding window approach
        for i in range(k, len(s)):
            if s[i] in vowels:
                curr += 1
            if s[i - k] in vowels:
                curr -= 1
            
            # Update the max_vowels with the maximum count found so far
            max_vowels = max(max_vowels, curr)
        
        return max_vowels
