import java.util.*;

class MinimumRemovalstoBalanceArray {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxEl, minEl;
        int L = 1;
        int i = 0;

        for (int j = 0; j < n; j++) {
            maxEl = nums[j];
            minEl = nums[i];

            while (i < j && maxEl > (long) k * minEl) {
                i++;
                minEl = nums[i];
            }

            L = Math.max(L, j - i + 1);
        }

        return n - L;
    }
}
