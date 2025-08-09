from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        for ind in range(len(nums)):
            num = nums[ind]
            if target - num in seen:
                return [seen[target - num], ind]
            seen[num] = ind
