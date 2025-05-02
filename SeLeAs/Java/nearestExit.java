import java.util.*;

public class nearestExit {
    public int NearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;

        Queue<int[]> cells = new LinkedList<>();
        cells.offer(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!cells.isEmpty()) {
            int[] current = cells.poll();
            int r = current[0];
            int c = current[1];
            int steps = current[2];

            for (int[] dir : directions) {
                int i = r + dir[0];
                int j = c + dir[1];

                if (i >= 0 && j >= 0 && i < rows && j < cols && maze[i][j] == '.') {
                    if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                        return steps + 1;
                    }
                    cells.offer(new int[]{i, j, steps + 1});
                    maze[i][j] = '+';
                }
            }
        }

        return -1;
    }
}
