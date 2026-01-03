import java.util.*;

class NumberofWaystoPaintN3Grid {
    private static final int MOD = 1000000007;
    
    // DP table
    int[][] dp;
    
    // 12 possible first-row states
    String[] states = {
        "RYG", "RGY", "RYR", "RGR",
        "YRG", "YGR", "YGY", "YRY",
        "GRY", "GYR", "GRG", "GYG"
    };
    
    private int solve(int n, int prev) {
        if (n == 0)
            return 1;
        
        if (dp[n][prev] != -1)
            return dp[n][prev];
        
        int result = 0;
        String last = states[prev];
        
        for (int curr = 0; curr < 12; curr++) {
            if (curr == prev)
                continue;
            
            String currPat = states[curr];
            boolean conflict = false;
            
            for (int col = 0; col < 3; col++) {
                if (currPat.charAt(col) == last.charAt(col)) {
                    conflict = true;
                    break;
                }
            }
            
            if (!conflict) {
                result = (result + solve(n - 1, curr)) % MOD;
            }
        }
        
        return dp[n][prev] = result;
    }
    
    public int numOfWays(int n) {
        dp = new int[n][12];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        int result = 0;
        
        // Choosing first row
        for (int i = 0; i < 12; i++) {
            result = (result + solve(n - 1, i)) % MOD;
        }
        
        return result;
    }
}
