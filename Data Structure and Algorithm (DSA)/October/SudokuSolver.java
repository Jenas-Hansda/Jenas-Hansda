class SudokuSolver {
    
    // Public method to start solving the Sudoku puzzle
    public void solveSudoku(char[][] board) {
        solve(board); // Start the backtracking process
    }

    // Recursive backtracking method to solve the board
    private boolean solve(char[][] board) {
        // Traverse every cell in the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // If the cell is empty
                if (board[i][j] == '.') {
                    // Try placing digits from '1' to '9'
                    for (char d = '1'; d <= '9'; d++) {
                        // Check if placing digit d is valid
                        if (isValid(board, i, j, d)) {
                            board[i][j] = d; // Place the digit

                            // Recursively attempt to solve with this digit placed
                            if (solve(board)) {
                                return true; // Solved!
                            }

                            // Backtrack: remove the digit and try the next one
                            board[i][j] = '.';
                        }
                    }
                    // If no digit fits, return false to trigger backtracking
                    return false;
                }
            }
        }
        // All cells are filled correctly; puzzle solved
        return true;
    }

    // Check if placing digit d at position (row, col) is valid
    private boolean isValid(char[][] board, int row, int col, char d) {
        // Check the row and column for duplicates
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == d) return false; // Same digit in column
            if (board[row][i] == d) return false; // Same digit in row
        }

        // Find the top-left corner of the 3x3 sub-grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        // Check the 3x3 sub-grid for duplicates
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (board[startRow + k][startCol + l] == d) {
                    return false; // Same digit in 3x3 box
                }
            }
        }

        // It's safe to place the digit
        return true;
    }
}
