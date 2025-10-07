class UniquePathsII {
    Integer[][] t;
    int m, n;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        // Edge case: start or end is blocked
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        t = new Integer[m][n];
        return solve(obstacleGrid, 0, 0);
    }

    int solve(int[][] obstacleGrid, int i, int j) {
        // Out of bounds or obstacle cell
        if (i >= m || j >= n || obstacleGrid[i][j] == 1) {
            return 0;
        }

        // Reached destination
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Return cached result
        if (t[i][j] != null) {
            return t[i][j];
        }

        // Explore right and down
        int right = solve(obstacleGrid, i, j + 1);
        int down = solve(obstacleGrid, i + 1, j);

        return t[i][j] = right + down;
    }
}
