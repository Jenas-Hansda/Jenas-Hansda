class MagicSquaresinGrid {

    private boolean isMagicGrid(int[][] grid, int r, int c) {
        // Center must be 5
        if (grid[r + 1][c + 1] != 5) return false;

        boolean[] seen = new boolean[10];

        // Check numbers 1 to 9 and uniqueness
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[r + i][c + j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        int SUM = 15;

        // Rows and columns
        for (int i = 0; i < 3; i++) {
            if (grid[r + i][c] + grid[r + i][c + 1] + grid[r + i][c + 2] != SUM)
                return false;

            if (grid[r][c + i] + grid[r + 1][c + i] + grid[r + 2][c + i] != SUM)
                return false;
        }

        // Diagonals
        if (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] != SUM)
            return false;

        if (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] != SUM)
            return false;

        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagicGrid(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
}
