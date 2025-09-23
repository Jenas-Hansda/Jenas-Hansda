import java.util.*;

class MaximumSumCircularSubarray {

    // Kadane's algorithm to find the max subarray sum
    private int kadanesMax(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    // Kadane's algorithm to find the min subarray sum
    private int kadanesMin(int[] nums) {
        int sum = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.min(nums[i], sum + nums[i]);
            minSum = Math.min(minSum, sum);
        }

        return minSum;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int maxSum = kadanesMax(nums);
        int minSum = kadanesMin(nums);

        int circularSum = totalSum - minSum;

        // Handle case where all numbers are negative
        if (maxSum > 0) {
            return Math.max(maxSum, circularSum);
        }

        return maxSum;
    }
}
