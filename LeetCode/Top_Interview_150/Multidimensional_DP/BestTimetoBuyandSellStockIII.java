class BestTimetoBuyandSellStockIII {
    private int[][][] memo;

    private int maxProfit(int day, int action, int[] prices, int transactionsLeft) {
        if (day >= prices.length || transactionsLeft == 0)
            return 0;

        if (memo[day][transactionsLeft][action] != -1)
            return memo[day][transactionsLeft][action];

        int maxProfit;
        if (action == 0) {
            // Buy
            int buy = maxProfit(day + 1, 1, prices, transactionsLeft) - prices[day];
            int skipBuy = maxProfit(day + 1, 0, prices, transactionsLeft);
            maxProfit = Math.max(buy, skipBuy);
        } else {
            // Sell
            int sell = maxProfit(day + 1, 0, prices, transactionsLeft - 1) + prices[day];
            int skipSell = maxProfit(day + 1, 1, prices, transactionsLeft);
            maxProfit = Math.max(sell, skipSell);
        }

        memo[day][transactionsLeft][action] = maxProfit;
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // memo[day][transactionsLeft][action]: action = 0 (buy), 1 (sell)
        memo = new int[n][3][2];
        
        // Initialize all values to -1 (to check if already computed)
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= 2; k++) {
                memo[i][k][0] = -1;
                memo[i][k][1] = -1;
            }
        }

        return maxProfit(0, 0, prices, 2);
    }
}
