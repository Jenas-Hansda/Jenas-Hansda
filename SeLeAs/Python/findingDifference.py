from typing import List
class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        nums1 = set(nums1)
        nums2 = set(nums2)
        ans = []
        for num in nums1:
            if num not in nums2:
                ans.append(num)
            else:
                nums2.remove(num)
            return [ans, list(nums2)]