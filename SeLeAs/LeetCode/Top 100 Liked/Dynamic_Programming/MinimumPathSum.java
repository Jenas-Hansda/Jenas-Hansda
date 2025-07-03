

public class MinimumPathSum {
    class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 && col != 0) {
                    grid[row][col] += grid[row][col - 1];
                } else if (col == 0 && row != 0) {
                    grid[row][col] += grid[row - 1][col];
                } else if (row != 0 && col != 0) {
                    grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);
                }
            }
        }
        return grid[rows - 1][cols - 1];
    }
}

}
