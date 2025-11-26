class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }

        int n = boxes.length;
        // dp[l][r][k] = max points from boxes[l..r] with k boxes equal to boxes[l] attached to its left
        int[][][] dp = new int[n][n][n];

        return dfs(boxes, dp, 0, n - 1, 0);
    }

    private int dfs(int[] boxes, int[][][] dp, int left, int right, int streak) {
        if (left > right) {
            return 0;
        }

        if (dp[left][right][streak] != 0) {
            return dp[left][right][streak];
        }

        // Optimization: merge consecutive boxes of the same color at the left edge
        // Example: [1,1,1,2,...] → treat all three 1’s as one group with streak+2
        int origLeft = left, origStreak = streak;
        while (left + 1 <= right && boxes[left + 1] == boxes[left]) {
            left++;
            streak++;
        }

        // Option 1: remove the current block of (streak + 1) same-colored boxes immediately
        int result = dfs(boxes, dp, left + 1, right, 0) + (streak + 1) * (streak + 1);

        // Option 2: try to merge non-contiguous boxes of the same color
        for (int i = left + 1; i <= right; i++) {
            if (boxes[i] == boxes[left]) {
                // Remove boxes between (left+1..i-1) first, then merge with boxes[i]
                result = Math.max(
                    result,
                    dfs(boxes, dp, left + 1, i - 1, 0) + dfs(boxes, dp, i, right, streak + 1)
                );
            }
        }

        dp[origLeft][right][origStreak] = result;
        return result;
    }
}
