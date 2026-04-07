class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int[][][] dp = new int[m][n][3];

        for (int k = 0; k < 3; k++) {
            dp[m-1][n-1][k] = (coins[m-1][n-1] < 0 && k > 0) ? 0 : coins[m-1][n-1];
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m-1 && j == n-1) continue;

                for (int k = 0; k < 3; k++) {
                    int best = Integer.MIN_VALUE;

                    int down = (i + 1 < m) ? dp[i+1][j][k] : Integer.MIN_VALUE;
                    int right = (j + 1 < n) ? dp[i][j+1][k] : Integer.MIN_VALUE;

                    if (down != Integer.MIN_VALUE || right != Integer.MIN_VALUE) {
                        best = coins[i][j] + Math.max(down, right);
                    }

                    if (coins[i][j] < 0 && k > 0) {
                        int skipDown = (i + 1 < m) ? dp[i+1][j][k-1] : Integer.MIN_VALUE;
                        int skipRight = (j + 1 < n) ? dp[i][j+1][k-1] : Integer.MIN_VALUE;
                        best = Math.max(best, Math.max(skipDown, skipRight));
                    }

                    dp[i][j][k] = best;
                }
            }
        }

        return dp[0][0][2];
    }
}