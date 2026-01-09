package Top_Interview_150.Matrix;

public class GameofLife {
    class Solution {
    
    // Function to check validity of neighbor coordinates
    private boolean isValidNeighbor(int x, int y, int[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
    
    public void gameOfLife(int[][] board) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; // 8 directions (row deltas)
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1}; // 8 directions (col deltas)

        int rows = board.length;
        int cols = board[0].length;

        // First pass: mark changes with temporary values
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int liveNeighbors = 0;

                for (int i = 0; i < 8; i++) {
                    int newX = row + dx[i];
                    int newY = col + dy[i];

                    if (isValidNeighbor(newX, newY, board) && Math.abs(board[newX][newY]) == 1) {
                        liveNeighbors++;
                    }
                }

                // Rule 1 or 3: live cell dies
                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = -1; // Mark as dead (was alive)
                }

                // Rule 4: dead cell becomes alive
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 2; // Mark as alive (was dead)
                }
            }
        }

        // Second pass: finalize the board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
}

}
