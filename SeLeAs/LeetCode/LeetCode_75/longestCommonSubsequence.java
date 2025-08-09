

public class longestCommonSubsequence{
    class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int rows = text1.length() + 1;
        int cols = text2.length() + 1;
        
        int[][] dp = new int[rows][cols];
        
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (text1.charAt(row - 1) == text2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }
        
        return dp[rows - 1][cols - 1];
    }
}

}