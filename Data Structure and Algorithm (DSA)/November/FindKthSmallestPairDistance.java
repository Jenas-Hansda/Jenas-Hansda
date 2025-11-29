class FindKthSmallestPairDistance {
    
    // Count number of pairs with distance <= mid
    private int countPairs(int[] nums, int mid) {
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            count += right - left;
        }
        return count;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int low = 0;
        int high = nums[n - 1] - nums[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countPairs(nums, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                ans = mid;    // possible answer
                high = mid - 1;
            }
        }
        return ans;
    }
}
