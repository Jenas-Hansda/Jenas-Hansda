class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1;

        // Step 1: Compute window sums
        int[] sums = new int[m];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k) sum -= nums[i - k];
            if (i >= k - 1) sums[i - k + 1] = sum;
        }

        // Step 2: best left indices
        int[] left = new int[m];
        int best = 0;
        for (int i = 0; i < m; i++) {
            if (sums[i] > sums[best]) best = i;
            left[i] = best;
        }

        // Step 3: best right indices
        int[] right = new int[m];
        best = m - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (sums[i] >= sums[best]) best = i;
            right[i] = best;
        }

        // Step 4: maximize left + mid + right
        int maxSum = 0;
        int[] ans = new int[3];

        for (int mid = k; mid < m - k; mid++) {
            int l = left[mid - k];
            int r = right[mid + k];

            int total = sums[l] + sums[mid] + sums[r];
            if (total > maxSum) {
                maxSum = total;
                ans[0] = l;
                ans[1] = mid;
                ans[2] = r;
            }
        }

        return ans;
    }
}
