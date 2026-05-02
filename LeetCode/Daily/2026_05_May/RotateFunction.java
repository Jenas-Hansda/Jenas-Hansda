class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int sum = 0;
        int F = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            F += i * nums[i];
        }

        int result = F;

        for (int k = 1; k < n; k++) {
            int newF = F + sum - n * nums[n - k];
            result = Math.max(result, newF);
            F = newF;
        }

        return result;
    }
}