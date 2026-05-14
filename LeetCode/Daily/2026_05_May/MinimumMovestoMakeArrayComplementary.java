class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] arr = new int[2 * limit + 2];

        for (int i = 0; i < (n >> 1); i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            arr[2] += 2;
            arr[Math.min(a, b) + 1]--;
            arr[Math.max(a, b) + limit + 1]++;
            arr[a + b]--;
            arr[a + b + 1]++;
        }

        int ans = n;
        int pref = 0;

        for (int i = 2; i <= 2 * limit; i++) {
            pref += arr[i];
            ans = Math.min(ans, pref);
        }

        return ans;
    }
}