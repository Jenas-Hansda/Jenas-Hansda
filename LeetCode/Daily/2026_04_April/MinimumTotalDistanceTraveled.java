import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Step 1: Sort robots and factories
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        int m = robot.size();
        int n = factory.length;

        long[][] dp = new long[m + 1][n + 1];

        // Step 2: Initialize with large value
        for (long[] row : dp) {
            Arrays.fill(row, (long)1e15);
        }

        // Base case: 0 robots = 0 cost
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        // Step 3: Fill DP
        for (int j = 1; j <= n; j++) {
            int pos = factory[j - 1][0];
            int limit = factory[j - 1][1];

            for (int i = 1; i <= m; i++) {
                // Option 1: Skip this factory
                dp[i][j] = dp[i][j - 1];

                long cost = 0;

                // Option 2: Assign k robots to this factory
                for (int k = 1; k <= Math.min(i, limit); k++) {
                    cost += Math.abs(robot.get(i - k) - pos);
                    dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + cost);
                }
            }
        }

        return dp[m][n];
    }
}