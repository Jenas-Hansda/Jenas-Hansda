import java.util.*;

class LargestSubmatrixwithRearrangements {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] prevRow = new int[n];
        int result = 0;

        for (int row = 0; row < m; row++) {
            int[] currRow = new int[n];

            // Build heights
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 1) {
                    currRow[col] = prevRow[col] + 1;
                } else {
                    currRow[col] = 0;
                }
            }

            // Sort in descending order
            Integer[] sortedRow = new Integer[n];
            for (int i = 0; i < n; i++) {
                sortedRow[i] = currRow[i];
            }

            Arrays.sort(sortedRow, Collections.reverseOrder());

            // Calculate max area
            for (int col = 0; col < n; col++) {
                int base = col + 1;
                int height = sortedRow[col];
                result = Math.max(result, base * height);
            }

            // Move to next row
            prevRow = currRow;
        }

        return result;
    }
}