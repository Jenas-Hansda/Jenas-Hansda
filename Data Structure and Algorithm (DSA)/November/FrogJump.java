import java.util.*;

class FrogJump {
    private Map<Integer, Integer> stoneIndexMap = new HashMap<>();
    private Boolean[][] dp;
    private int n;

    private boolean solve(int[] stones, int index, int prevJump) {
        if (index == n - 1) return true;

        if (dp[index][prevJump] != null) return dp[index][prevJump];

        for (int nextJump = prevJump - 1; nextJump <= prevJump + 1; nextJump++) {
            if (nextJump > 0) {
                int nextStone = stones[index] + nextJump;
                if (stoneIndexMap.containsKey(nextStone)) {
                    int nextIndex = stoneIndexMap.get(nextStone);
                    if (solve(stones, nextIndex, nextJump)) {
                        return dp[index][prevJump] = true;
                    }
                }
            }
        }

        return dp[index][prevJump] = false;
    }

    public boolean canCross(int[] stones) {
        if (stones.length < 2 || stones[1] != 1) return false;

        n = stones.length;
        dp = new Boolean[n][n + 1]; // prevJump can be up to n
        for (int i = 0; i < n; i++) {
            stoneIndexMap.put(stones[i], i);
        }

        return solve(stones, 0, 0);
    }
}
