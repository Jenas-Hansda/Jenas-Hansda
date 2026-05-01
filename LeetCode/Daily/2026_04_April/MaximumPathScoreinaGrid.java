class Solution {

    public int solve(int i, int j, int[][] grid, int k, int c, int[][][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if (i == m || j == n) {
            return Integer.MIN_VALUE;
        }

        if (dp[i][j][c] != -1) {
            return dp[i][j][c];
        }

        int score = 0;
        int cost = 0;

        if (grid[i][j] == 1) {
            score += 1;
            cost += 1;
        } else if (grid[i][j] == 2) {
            score += 2;
            cost += 1;
        }

        if (c + cost > k) {
            return dp[i][j][c] = Integer.MIN_VALUE;
        }

        if (i == m - 1 && j == n - 1) {
            return dp[i][j][c] = score;
        }

        int right = solve(i, j + 1, grid, k, c + cost, dp);
        int down = solve(i + 1, j, grid, k, c + cost, dp);

        int best = Math.max(right, down);

        if (best != Integer.MIN_VALUE) {
            best += score;
        }

        return dp[i][j][c] = best;
    }

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];

        // initialize dp with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = -1;
                }
            }
        }

        int ans = solve(0, 0, grid, k, 0, dp);
        return (ans == Integer.MIN_VALUE) ? -1 : ans;
    }
}