class FindMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean contains1 = false;

        for (int i = 0; i < n; i++) {
            // Check whether 1 is in the original array
            if (nums[i] == 1) {
                contains1 = true;
            }
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        if (!contains1) return 1;

        // Mark whether integers 1 to n are in nums
        // Use index as a hash key and negative sign as a presence detector.
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            int idx = val - 1;

            if (nums[idx] < 0) continue;
            nums[idx] *= -1;
        }

        // First positive in nums is smallest missing positive integer
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i + 1;
        }

        return n + 1;
    }
}