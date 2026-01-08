class MaxDotProductofTwoSubsequences {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int NEG = -100000000;
        int[][] dp = new int[m + 1][n + 1];

        // Initialize DP table with large negative values
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = NEG;
            }
        }

        // Fill DP from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int val = nums1[i] * nums2[j];

                dp[i][j] = Math.max(
                    val, // take only this pair
                    Math.max(
                        dp[i + 1][j + 1] + val, // take both
                        Math.max(
                            dp[i + 1][j],       // skip nums1[i]
                            dp[i][j + 1]        // skip nums2[j]
                        )
                    )
                );
            }
        }

        return dp[0][0];
    }
}
