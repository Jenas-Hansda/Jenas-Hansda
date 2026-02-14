public class ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        
        // DP table
        double[][] dp = new double[101][101];
        
        // Initial condition
        dp[0][0] = poured;

        // Build row by row
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                
                // If overflow happens
                if (dp[i][j] > 1.0) {
                    double overflow = (dp[i][j] - 1.0) / 2.0;
                    
                    dp[i + 1][j] += overflow;
                    dp[i + 1][j + 1] += overflow;
                    
                    dp[i][j] = 1.0; // cap current glass
                }
            }
        }

        return Math.min(1.0, dp[query_row][query_glass]);
    }
}
