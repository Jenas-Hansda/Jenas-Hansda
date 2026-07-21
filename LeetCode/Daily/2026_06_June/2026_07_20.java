class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int n = rows * cols;

        k %= n;
        if (k == 0) {
            List<List<Integer>> result = new ArrayList<>();
            for (int[] row : grid) {
                List<Integer> list = new ArrayList<>();
                for (int val : row) {
                    list.add(val);
                }
                result.add(list);
            }
            return result;
        }

        reverse(grid, 0, n - 1, cols);
        reverse(grid, 0, k - 1, cols);
        reverse(grid, k, n - 1, cols);

        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> list = new ArrayList<>();
            for (int val : row) {
                list.add(val);
            }
            result.add(list);
        }
        return result;
    }

    private void reverse(int[][] grid, int left, int right, int cols) {
        while (left < right) {
            int r1 = left / cols;
            int c1 = left % cols;
            int r2 = right / cols;
            int c2 = right % cols;

            int temp = grid[r1][c1];
            grid[r1][c1] = grid[r2][c2];
            grid[r2][c2] = temp;

            left++;
            right--;
        }
    }
}
