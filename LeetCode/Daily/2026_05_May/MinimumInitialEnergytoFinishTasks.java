import java.util.*;

class Solution {

    private boolean isPossible(int[][] tasks, int mid) {

        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];

            if (minimum > mid) {
                return false;
            }

            mid -= actual;
        }

        return true;
    }

    public int minimumEffort(int[][] tasks) {

        int left = 0;
        int right = (int)1e9;

        int result = Integer.MAX_VALUE;

        Arrays.sort(tasks, (a, b) -> {
            int diff1 = a[1] - a[0];
            int diff2 = b[1] - b[0];

            return diff2 - diff1; // descending
        });

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (isPossible(tasks, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}