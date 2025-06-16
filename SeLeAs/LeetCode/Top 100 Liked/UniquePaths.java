

public class UniquePaths {
    class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }

        int[][] dp = new int[n][m];

        for (int row = 0; row < n; row++) {
            dp[row][0] = 1;
        }
        for (int col = 0; col < m; col++) {
            dp[0][col] = 1;
        }

        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }

        return dp[n - 1][m - 1];
    }
}
}