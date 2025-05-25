class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.split()
        reversed_words = s[::-1]
        return ' '.join(reversed_words)
