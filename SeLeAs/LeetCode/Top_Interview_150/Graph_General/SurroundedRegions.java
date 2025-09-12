class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Start DFS from border 'O's and mark them as '1'
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0);          // First column
            dfs(board, i, cols - 1);   // Last column
        }
        for (int j = 0; j < cols; j++) {
            dfs(board, 0, j);          // First row
            dfs(board, rows - 1, j);   // Last row
        }

        // Step 2: Flip surrounded 'O's to 'X', and '1's back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';  // Enclosed region
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';  // Border-connected region
                }
            }
        }
    }

    // Helper method: flood-fill from border 'O's and mark them as '1'
    private void dfs(char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O') return;

        board[i][j] = '1';  // Temporarily mark as visited

        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
