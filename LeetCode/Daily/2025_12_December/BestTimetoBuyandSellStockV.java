// Approach (Bottom Up DP)
// Time Complexity : O(n * K)
// Space Complexity: O(n * K)

class BestTimetoBuyandSellStockV {

    private static final long NEG_INF = Long.MIN_VALUE / 4;

    public long maximumProfit(int[] prices, int K) {
        int n = prices.length;

        // t[i][k][state]
        // state:
        // 0 -> no open transaction
        // 1 -> holding long (bought)
        // 2 -> holding short (sold)
        long[][][] t = new long[n + 1][K + 1][3];

        // Base case: day n (after last day)
        for (int k = 0; k <= K; k++) {
            t[n][k][0] = 0;
            t[n][k][1] = NEG_INF;
            t[n][k][2] = NEG_INF;
        }

        // Fill DP table bottom-up
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0; k <= K; k++) {

                // =========================
                // CASE 0: no open position
                // =========================
                // Do nothing
                t[i][k][0] = t[i + 1][k][0];

                // Start a transaction (only if we have capacity)
                if (k > 0) {
                    // Buy (open long)
                    t[i][k][0] = Math.max(
                        t[i][k][0],
                        -prices[i] + t[i + 1][k][1]
                    );

                    // Short sell (open short)
                    t[i][k][0] = Math.max(
                        t[i][k][0],
                         prices[i] + t[i + 1][k][2]
                    );
                }

                // =========================
                // CASE 1: holding long
                // =========================
                if (k == 0) {
                    t[i][k][1] = NEG_INF;
                } else {
                    // Hold
                    t[i][k][1] = t[i + 1][k][1];

                    // Sell today (close long, consume 1 transaction)
                    t[i][k][1] = Math.max(
                        t[i][k][1],
                        prices[i] + t[i + 1][k - 1][0]
                    );
                }

                // =========================
                // CASE 2: holding short
                // =========================
                if (k == 0) {
                    t[i][k][2] = NEG_INF;
                } else {
                    // Hold
                    t[i][k][2] = t[i + 1][k][2];

                    // Buy back today (close short, consume 1 transaction)
                    t[i][k][2] = Math.max(
                        t[i][k][2],
                        -prices[i] + t[i + 1][k - 1][0]
                    );
                }
            }
        }

        // Start at day 0, with K transactions available, no open position
        return t[0][K][0];
    }
}
