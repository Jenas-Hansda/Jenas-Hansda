class BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        // If k >= n/2, same as unlimited transactions
        if (k >= n / 2) {
            int res = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1])
                    res += prices[i] - prices[i - 1];
            }
            return res;
        }

        int[][] dp = new int[k + 1][n];

        for (int i = 1; i <= k; i++) {
            int bestBuy = -prices[0];  // best dp[i-1][j] - prices[j]
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + bestBuy);
                bestBuy = Math.max(bestBuy, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][n - 1];
    }
}
