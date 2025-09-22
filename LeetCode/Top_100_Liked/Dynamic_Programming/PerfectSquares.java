import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares {
    public class Solution {
    public int numSquares(int n) {
        // DP array to store the least number of perfect squares summing up to i
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // base case

        // Precompute all perfect squares ≤ n
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        // Build the solution from 1 to n
        for (int i = 1; i <= n; i++) {
            for (int square : squares) {
                if (square > i) break;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }

        return dp[n];
    }
}
}