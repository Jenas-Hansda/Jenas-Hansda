// Approach (Using sorting and two pointers)
// T.C : O(n log n)
// S.C : O(1) (ignoring sort's internal stack)

import java.util.Arrays;

class MinimumDifferenceBetweenHighestandLowestofKScores {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;

        // Edge case: if k == 1, difference is always 0
        if (k == 1) return 0;

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        int i = 0;
        int j = i + k - 1;

        while (j < n) {
            int minElement = nums[i];
            int maxElement = nums[j];

            minDiff = Math.min(minDiff, maxElement - minElement);
            i++;
            j++;
        }

        return minDiff;
    }
}
