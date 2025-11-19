class KInversePairsArray {
    static final int MOD = 1_000_000_007;

    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            long cum = 1;
            for (int j = 1; j <= k; j++) {
                cum = (cum + dp[i-1][j]) % MOD;
                if (j >= i) {
                    cum = (cum - dp[i-1][j-i] + MOD) % MOD;
                }
                dp[i][j] = (int) cum;
            }
        }

        return dp[n][k];
    }
}
