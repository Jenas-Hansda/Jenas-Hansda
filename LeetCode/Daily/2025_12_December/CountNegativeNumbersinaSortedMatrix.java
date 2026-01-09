class CountNegativeNumbersinaSortedMatrix {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int row = m - 1;
        int col = 0;
        int result = 0;

        while (row >= 0 && col < n) {
            if (grid[row][col] < 0) {
                result += n - col;
                row--;
            } else {
                col++;
            }
        }
        return result;
    }
}
