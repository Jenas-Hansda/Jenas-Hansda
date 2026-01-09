package Sliding_Window;

import java.util.*;
class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>(); // store indices
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int ptr = 0;

        for (int j = 0; j < n; j++) {
            // Remove indices of elements not in the current window
            while (!q.isEmpty() && q.peekFirst() <= j - k) {
                q.pollFirst();
            }

            // Remove indices of all elements smaller than nums[j]
            while (!q.isEmpty() && nums[q.peekLast()] < nums[j]) {
                q.pollLast();
            }

            q.addLast(j);

            // Window is valid
            if (j >= k - 1) {
                res[ptr++] = nums[q.peekFirst()];
            }
        }

        return res;
    }
}
