class Solution {
    public int[] maxValue(int[] nums) {

        int n = nums.length;

        // maxLeft[i] = maximum element from index 0 to i
        int[] maxLeft = new int[n];

        // minRight[i] = minimum element from index i to n-1
        int[] minRight = new int[n];

        maxLeft[0] = nums[0];
        minRight[n - 1] = nums[n - 1];

        // Build prefix maximum array
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }

        // Build suffix minimum array
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], nums[i]);
        }

        int[] ans = new int[n];

        ans[n - 1] = maxLeft[n - 1];

        // Build answer array
        for (int i = n - 2; i >= 0; i--) {

            // Cannot move to the right
            if (maxLeft[i] <= minRight[i + 1]) {
                ans[i] = maxLeft[i];
            } else {
                ans[i] = ans[i + 1];
            }
        }

        return ans;
    }
}