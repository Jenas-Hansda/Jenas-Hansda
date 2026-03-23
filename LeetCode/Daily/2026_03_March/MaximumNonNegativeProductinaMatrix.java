class MaximumNonNegativeProductinaMatrix {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        // dp[i][j][0] = max product till (i,j)
        // dp[i][j][1] = min product till (i,j)
        long[][][] dp = new long[m][n][2];

        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];

        // first row
        for (int j = 1; j < n; j++) {
            dp[0][j][0] = dp[0][j - 1][0] * grid[0][j];
            dp[0][j][1] = dp[0][j - 1][1] * grid[0][j];
        }

        // first column
        for (int i = 1; i < m; i++) {
            dp[i][0][0] = dp[i - 1][0][0] * grid[i][0];
            dp[i][0][1] = dp[i - 1][0][1] * grid[i][0];
        }

        // fill rest
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long upMax = dp[i - 1][j][0];
                long upMin = dp[i - 1][j][1];

                long leftMax = dp[i][j - 1][0];
                long leftMin = dp[i][j - 1][1];

                long a = upMax * grid[i][j];
                long b = upMin * grid[i][j];
                long c = leftMax * grid[i][j];
                long d = leftMin * grid[i][j];

                dp[i][j][0] = Math.max(Math.max(a, b), Math.max(c, d));
                dp[i][j][1] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long maxProd = dp[m - 1][n - 1][0];

        if (maxProd < 0) return -1;
        return (int)(maxProd % MOD);
    }
}