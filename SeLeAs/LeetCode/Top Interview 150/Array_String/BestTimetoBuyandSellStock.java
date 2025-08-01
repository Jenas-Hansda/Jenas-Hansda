package Array_String;

class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int buy = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - buy);
        }

        return maxProfit;
    }
}