package Top_Interview_150.Sliding_Window;

public class MinimumSizeSubarraySum {
    
  public int minSubArrayLen(int target, int[] nums) {
    int minLength = Integer.MAX_VALUE;
    int currentSum = 0;
    int start = 0;

    for (int end = 0; end < nums.length; end++) {
      currentSum += nums[end];

      while (currentSum >= target) {
        minLength = Math.min(minLength, end - start + 1);
        currentSum -= nums[start++];
      }
    }

    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }
}