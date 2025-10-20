class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // We only need 1D array to store the "minimum health required" for the next row
        int[] dp = new int[n];

        // Start from the bottom-right cell
        dp[n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);

        // Fill the last row (from right to left)
        for (int j = n - 2; j >= 0; j--) {
            dp[j] = Math.max(1, dp[j + 1] - dungeon[m - 1][j]);
        }

        // Fill the rest of the grid bottom-up
        for (int i = m - 2; i >= 0; i--) {
            // Update the last column first
            dp[n - 1] = Math.max(1, dp[n - 1] - dungeon[i][n - 1]);

            // Then fill the row from right to left
            for (int j = n - 2; j >= 0; j--) {
                int minNext = Math.min(dp[j], dp[j + 1]);
                dp[j] = Math.max(1, minNext - dungeon[i][j]);
            }
        }

        // dp[0] now holds the minimum health required at the start
        return dp[0];
    }
}
