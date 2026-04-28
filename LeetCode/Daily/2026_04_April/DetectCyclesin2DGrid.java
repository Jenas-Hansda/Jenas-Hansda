import java.util.*;

class Solution {
    int m, n;
    int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (cycleDetectBFS(i, j, grid, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean cycleDetectBFS(int r, int c, char[][] grid, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        
        // {curr_r, curr_c, prev_r, prev_c}
        queue.offer(new int[]{r, c, -1, -1});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curr_r = curr[0];
            int curr_c = curr[1];
            int prev_r = curr[2];
            int prev_c = curr[3];

            for (int[] dir : directions) {
                int new_r = curr_r + dir[0];
                int new_c = curr_c + dir[1];

                if (new_r >= 0 && new_r < m && new_c >= 0 && new_c < n
                        && grid[new_r][new_c] == grid[curr_r][curr_c]) {

                    if (new_r == prev_r && new_c == prev_c)
                        continue;

                    if (visited[new_r][new_c])
                        return true;

                    visited[new_r][new_c] = true;
                    queue.offer(new int[]{new_r, new_c, curr_r, curr_c});
                }
            }
        }
        return false;
    }
}