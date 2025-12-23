import java.util.*;

class TwoBestNonOverlappingEvents {
    int n;
    int[][] dp;

    // Binary search to find the first event whose start time > endTime
    private int binarySearch(int[][] events, int endTime) {
        int left = 0, right = n - 1;
        int result = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] > endTime) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private int solve(int[][] events, int index, int count) {
        if (count == 2 || index >= n) {
            return 0;
        }

        if (dp[index][count] != -1) {
            return dp[index][count];
        }

        // Take current event
        int nextIndex = binarySearch(events, events[index][1]);
        int take = events[index][2] + solve(events, nextIndex, count + 1);

        // Skip current event
        int notTake = solve(events, index + 1, count);

        return dp[index][count] = Math.max(take, notTake);
    }

    public int maxTwoEvents(int[][] events) {
        n = events.length;

        // Sort events by start time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(events, 0, 0);
    }
}
