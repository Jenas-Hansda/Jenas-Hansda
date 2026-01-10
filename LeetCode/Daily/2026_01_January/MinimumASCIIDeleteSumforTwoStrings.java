class MinimumASCIIDeleteSumforTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Base case: when s1 is exhausted
        for (int j = n - 1; j >= 0; j--) {
            dp[m][j] = dp[m][j + 1] + s2.charAt(j);
        }

        // Base case: when s2 is exhausted
        for (int i = m - 1; i >= 0; i--) {
            dp[i][n] = dp[i + 1][n] + s1.charAt(i);
        }

        // Fill DP table
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    int deleteS1 = s1.charAt(i) + dp[i + 1][j];
                    int deleteS2 = s2.charAt(j) + dp[i][j + 1];
                    dp[i][j] = Math.min(deleteS1, deleteS2);
                }
            }
        }

        return dp[0][0];
    }
}
