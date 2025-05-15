

public class maxProfit {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            if (n <= 1) return 0;

            int cash = 0; // Not holding
            int hold = -prices[0] - fee; // Holding stock after buying

            for (int i = 1; i < n; i++) {
                int prevCash = cash;
                cash = Math.max(cash, hold + prices[i]); // Sell
                hold = Math.max(hold, prevCash - prices[i] - fee); // Buy
            }

            return cash;
        }
    }
}
