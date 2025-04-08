from collections import Counter

class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        if len(word1) != len(word2):  # Ensure the words are of the same length
            return False
        
        counts1 = Counter(word1)
        counts2 = Counter(word2)
        
        # Check if the unique characters match and the frequency of characters match
        return (set(counts1.keys()) == set(counts2.keys())) and \
               (sorted(counts1.values()) == sorted(counts2.values()))
