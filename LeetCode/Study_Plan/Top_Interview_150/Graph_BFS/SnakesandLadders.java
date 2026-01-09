import java.util.*;

class SnakesandLadders {
    int n;

    // Converts a cell number to board coordinates, considering the zigzag pattern
    private int[] getCoordinates(int s) {
        int row = n - 1 - (s - 1) / n;
        int col = (s - 1) % n;

        // Flip column direction based on row parity and board width
        if ((n % 2 == 1 && row % 2 == 1) || (n % 2 == 0 && row % 2 == 0)) {
            col = n - 1 - col;
        }

        return new int[]{row, col};
    }

    public int snakesAndLadders(int[][] board) {
        n = board.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);  // Start from cell 1
        visited[n - 1][0] = true;  // Mark starting cell as visited

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int curr = queue.poll();
                if (curr == n * n) return steps;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > n * n) break;

                    int[] nextCoord = getCoordinates(next);
                    int row = nextCoord[0], col = nextCoord[1];

                    int destination = board[row][col] == -1 ? next : board[row][col];
                    int[] destCoord = getCoordinates(destination);
                    int destRow = destCoord[0], destCol = destCoord[1];

                    if (visited[destRow][destCol]) continue;

                    visited[destRow][destCol] = true;
                    queue.offer(destination);
                }
            }

            steps++;
        }

        return -1;  // End cell unreachable
    }
}
