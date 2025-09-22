class MaximumSubarray {

  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int localMax = nums[0];  // Maximum sum ending at current position
    int globalMax = nums[0]; // Overall maximum sum found so far

    for (int i = 1; i < nums.length; i++) {
      localMax = Math.max(nums[i], nums[i] + localMax);
      globalMax = Math.max(globalMax, localMax);
    }

    return globalMax;
  }

}
