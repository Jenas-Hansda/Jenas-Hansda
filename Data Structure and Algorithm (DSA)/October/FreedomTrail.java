class FreedomTrail {
    
    private int countSteps(int ringIndex, int i, int n) {
        int dist = Math.abs(i - ringIndex);
        int wrapAround = n - dist;
        return Math.min(dist, wrapAround);
    }
    
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        
        int[][] dp = new int[n][m + 1];
        
        // Base case: when all characters in key are processed, cost is 0
        for (int ringIndex = 0; ringIndex < n; ringIndex++) {
            dp[ringIndex][m] = 0;
        }
        
        // Bottom-up filling
        for (int keyIndex = m - 1; keyIndex >= 0; keyIndex--) {
            for (int ringIndex = 0; ringIndex < n; ringIndex++) {
                int result = Integer.MAX_VALUE;
                
                for (int i = 0; i < n; i++) {
                    if (ring.charAt(i) == key.charAt(keyIndex)) {
                        int totalSteps = countSteps(ringIndex, i, n) + 1 + dp[i][keyIndex + 1];
                        result = Math.min(result, totalSteps);
                    }
                }
                
                dp[ringIndex][keyIndex] = result;
            }
        }
        
        return dp[0][0];
    }
}
