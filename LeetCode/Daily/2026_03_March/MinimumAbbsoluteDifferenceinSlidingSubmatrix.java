import java.util.*;

class MinimumAbbsoluteDifferenceinSlidingSubmatrix {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {

                // Sorted set with unique values
                TreeSet<Integer> vals = new TreeSet<>();

                for (int r = i; r < i + k; r++) {
                    for (int c = j; c < j + k; c++) {
                        vals.add(grid[r][c]);
                    }
                }

                // If only one unique element
                if (vals.size() == 1) {
                    continue;
                }

                int minAbsDiff = Integer.MAX_VALUE;

                Iterator<Integer> it = vals.iterator();
                int prev = it.next();

                while (it.hasNext()) {
                    int curr = it.next();
                    minAbsDiff = Math.min(minAbsDiff, curr - prev);
                    prev = curr;
                }

                result[i][j] = minAbsDiff;
            }
        }

        return result;
    }
}