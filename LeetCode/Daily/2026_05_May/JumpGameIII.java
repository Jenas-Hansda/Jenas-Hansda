import java.util.*;

class Solution {

    public boolean canReach(int[] arr, int start) {

        int n = arr.length;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {

            int curr = queue.poll();

            // Already visited
            if (arr[curr] < 0)
                continue;

            // Reached zero
            if (arr[curr] == 0)
                return true;

            int jump = arr[curr];

            int left = curr - jump;
            int right = curr + jump;

            if (left >= 0)
                queue.offer(left);

            if (right < n)
                queue.offer(right);

            // Mark visited
            arr[curr] = -arr[curr];
        }

        return false;
    }
}