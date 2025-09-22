public class Searcha2DMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // Check for null matrix or empty dimensions
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            int n = matrix.length; // Number of rows
            int m = matrix[0].length; // Number of columns

            // Treat the 2D matrix as a flattened 1D array
            int lo = 0;
            int hi = n * m - 1;

            // Perform binary search on the virtual 1D array
            while (lo <= hi) {
                // Compute the mid index to avoid overflow
                int mid = lo + (hi - lo) / 2;

                // Convert 1D mid index to 2D indices: row = mid / m, col = mid % m
                int midValue = matrix[mid / m][mid % m];

                // Compare the middle value with the target
                if (midValue == target) {
                    return true; // Target found
                } else if (midValue < target) {
                    lo = mid + 1; // Search in the right half
                } else {
                    hi = mid - 1; // Search in the left half
                }
            }

            // Target not found
            return false;
        }
    }

}
