class DivideanArrayintoSubarrayswithMinimumCostI {
    public int minimumCost(int[] nums) {
        int n = nums.length;

        int firstMin = nums[0];
        int secondMin = Integer.MAX_VALUE;
        int thirdMin = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (nums[i] < secondMin) {
                thirdMin = secondMin;
                secondMin = nums[i];
            } else if (nums[i] < thirdMin) {
                thirdMin = nums[i];
            }
        }

        return firstMin + secondMin + thirdMin;
    }
}
