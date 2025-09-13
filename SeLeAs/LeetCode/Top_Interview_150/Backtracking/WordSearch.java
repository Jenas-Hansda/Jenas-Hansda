class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, int ind) {
        if (ind == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            board[row][col] != word.charAt(ind)) {
            return false;
        }

        char letter = board[row][col];
        board[row][col] = '#'; 

        boolean found =
            dfs(board, word, row - 1, col, ind + 1) ||
            dfs(board, word, row + 1, col, ind + 1) ||
            dfs(board, word, row, col - 1, ind + 1) ||
            dfs(board, word, row, col + 1, ind + 1);

        board[row][col] = letter; 
        return found;
    }
    
}