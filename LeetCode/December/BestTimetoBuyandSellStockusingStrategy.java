// Approach (Using Khandani Sliding Window)
// T.C : O(n)
// S.C : O(n)

class BestTimetoBuyandSellStockusingStrategy {

    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long actualProfit = 0;
        long[] profit = new long[n]; // original profit of each day

        for (int i = 0; i < n; i++) {
            profit[i] = (long) strategy[i] * prices[i];
            actualProfit += profit[i];
        }

        long originalWindowProfit = 0;
        long modifiedWindowProfit = 0;
        long maxGain = 0; // modifiedWindowProfit - originalWindowProfit

        int i = 0, j = 0;

        // Khandani sliding window technique
        while (j < n) {

            originalWindowProfit += profit[j];

            // Second half of the window contributes to modifiedWindowProfit
            if (j - i + 1 > k / 2) {
                modifiedWindowProfit += prices[j];
            }

            if (j - i + 1 > k) {
                originalWindowProfit -= profit[i];
                modifiedWindowProfit -= prices[i + k / 2];
                i++;
            }

            // Evaluate window of size k
            if (j - i + 1 == k) {
                maxGain = Math.max(maxGain,
                        modifiedWindowProfit - originalWindowProfit);
            }

            j++;
        }

        return actualProfit + maxGain;
    }
}
