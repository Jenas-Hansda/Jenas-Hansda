from collections import Counter

class Solution:
    def uniqueOccurrences(self, arr):
        # Count the frequency of each element in arr
        count_map = Counter(arr)
        
        # Get the list of frequencies of the elements
        frequencies = list(count_map.values())
        
        # Check if all frequencies are unique
        return len(frequencies) == len(set(frequencies))
