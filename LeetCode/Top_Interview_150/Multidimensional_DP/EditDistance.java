class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[j][0] = j;
        }

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j][i] = dp[j - 1][i - 1];
                } else {
                    dp[j][i] = Math.min(
                        Math.min(dp[j][i - 1], dp[j - 1][i]),
                        dp[j - 1][i - 1]
                    ) + 1;
                }
            }
        }

        return dp[n][m];
    }
}