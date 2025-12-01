class SplitArrayLargestSum {

    // Helper function to determine how many subarrays can be formed 
    // with the given maximum sum 'mid'
    private int isPossible(int[] nums, int mid) {
        int count = 0;
        int tempSum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (tempSum + nums[i] <= mid) {
                tempSum += nums[i];
            } else {
                count++;
                tempSum = nums[i];
            }
        }
        count++; // for the last subarray
        return count;
    }

    // Main function to split array into m subarrays minimizing the largest sum
    public int splitArray(int[] nums, int m) {
        int l = 0, r = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            l = Math.max(l, nums[i]); // lower bound = largest single element
            r += nums[i];             // upper bound = sum of all elements
        }

        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            int count = isPossible(nums, mid);

            if (count <= m) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
