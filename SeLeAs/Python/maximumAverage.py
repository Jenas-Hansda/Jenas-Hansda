from typing import List

class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        curr_sum = max_sum = sum(nums[:k])  # Initialize current sum and max sum with the first window
        for i in range(1, len(nums) - k + 1):  # Sliding window from index 1 to len(nums) - k
            curr_sum += nums[i + k - 1] - nums[i - 1]  # Update the sum by sliding the window
            max_sum = max(max_sum, curr_sum)  # Update max_sum if a larger sum is found
        return max_sum / k  # Return the average of the maximum sum
