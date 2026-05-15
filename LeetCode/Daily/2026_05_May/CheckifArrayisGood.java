class Solution {
    public boolean isGood(int[] nums) {

        int n = nums.length;
        int maxEl = n - 1;

        int maxCount = 0;

        for (int i = 0; i < n; i++) {

            int val = Math.abs(nums[i]);

            // Value should be between 1 and n-1
            if (val < 1 || val > maxEl) {
                return false;
            }

            // Count occurrences of max element
            if (val == maxEl) {
                maxCount++;

                if (maxCount > 2) {
                    return false;
                }
            }

            // Check duplicate for numbers except maxEl
            if (val != maxEl) {

                if (nums[val - 1] < 0) {
                    return false;
                }

                nums[val - 1] *= -1;
            }
        }

        // max element must appear exactly twice
        return maxCount == 2;
    }
}