from typing import List

class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        max_len = 0
        start = 0
        zero_count = 0
        
        for end in range(len(nums)):
            if nums[end] == 0:
                zero_count += 1
            
            while zero_count > 1:
                if nums[start] == 0:
                    zero_count -= 1
                start += 1
            
            # Calculate the length of the current valid window
            max_len = max(max_len, end - start)
        
        return max_len
