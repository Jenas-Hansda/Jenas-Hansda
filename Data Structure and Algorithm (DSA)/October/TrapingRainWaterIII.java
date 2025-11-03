import java.util.*;

class TrapingRainWaterIII {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        // Edge case: too small to trap any water
        if (m <= 2 || n <= 2) return 0;

        // Min-heap storing {height, row, col}
        PriorityQueue<int[]> boundaryCells = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[m][n];

        // Add boundary cells (left-most and right-most columns)
        for (int row = 0; row < m; row++) {
            boundaryCells.offer(new int[]{heightMap[row][0], row, 0});
            visited[row][0] = true;
            if (n > 1) {
                boundaryCells.offer(new int[]{heightMap[row][n - 1], row, n - 1});
                visited[row][n - 1] = true;
            }
        }

        // Add boundary cells (top and bottom rows, excluding corners)
        for (int col = 1; col < n - 1; col++) {
            boundaryCells.offer(new int[]{heightMap[0][col], 0, col});
            visited[0][col] = true;
            if (m > 1) {
                boundaryCells.offer(new int[]{heightMap[m - 1][col], m - 1, col});
                visited[m - 1][col] = true;
            }
        }

        int water = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Process cells from the min-heap
        while (!boundaryCells.isEmpty()) {
            int[] cell = boundaryCells.poll();
            int height = cell[0];
            int i = cell[1];
            int j = cell[2];

            // Explore neighbors
            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                    visited[ni][nj] = true;

                    // If neighbor is lower, water can be trapped
                    if (height > heightMap[ni][nj]) {
                        water += height - heightMap[ni][nj];
                    }

                    // Push the neighbor with updated effective height
                    boundaryCells.offer(new int[]{Math.max(height, heightMap[ni][nj]), ni, nj});
                }
            }
        }

        return water;
    }
}
