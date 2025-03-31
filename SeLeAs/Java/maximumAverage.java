public class maximumAverage {
    public double findMaxAverage(int[] nums, int k) {
        // Initialize the current sum and max sum with the first window of size k
        int currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }
        
        int maxSum = currSum;  // Set maxSum initially to currSum
        
        // Sliding window logic
        for (int i = k; i < nums.length; i++) {
            currSum += nums[i] - nums[i - k];  // Update the current sum by adding the next element and removing the previous one
            maxSum = Math.max(maxSum, currSum);  // Update maxSum if a larger sum is found
        }
        
        // Return the average of the maximum sum
        return (double) maxSum / k;
    }
}
