class FindAllPossibleStableBinaryArraysII {
    static final int MOD = 1000000007;

    public int numberOfStableArrays(int zero, int one, int limit) {

        int[][][] dp = new int[zero + 1][one + 1][2];

        // Only zeros
        for (int i = 0; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }

        // Only ones
        for (int j = 0; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }

        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {

                if (i == 0 || j == 0) continue;

                // Last element = 1
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;

                if (j - 1 >= limit) {
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j - 1 - limit][0] + MOD) % MOD;
                }

                // Last element = 0
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;

                if (i - 1 >= limit) {
                    dp[i][j][0] = (dp[i][j][0] - dp[i - 1 - limit][j][1] + MOD) % MOD;
                }
            }
        }

        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
    }
}