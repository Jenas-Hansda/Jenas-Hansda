class NQueensII {
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] mainD = new boolean[2 * n - 1];  // ↘ diagonals
        boolean[] antiD = new boolean[2 * n - 1];  // ↙ diagonals
        return dfs(0, col, mainD, antiD, n);
    }

    private int dfs(int row, boolean[] col, boolean[] mainD, boolean[] antiD, int n) {
        if (row == n) {
            return 1;  // found valid arrangement
        }
        int count = 0;
        for (int j = 0; j < n; j++) {
            int d1 = row + j;         // main diagonal index
            int d2 = row - j + n - 1; // anti-diagonal index
            if (!col[j] && !mainD[d1] && !antiD[d2]) {
                col[j] = mainD[d1] = antiD[d2] = true;
                count += dfs(row + 1, col, mainD, antiD, n);
                col[j] = mainD[d1] = antiD[d2] = false; // backtrack
            }
        }
        return count;
    }
}
