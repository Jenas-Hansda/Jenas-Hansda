class MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold {

    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length;
        int cols = mat[0].length;

        // 2D Prefix Sum
        int[][] prefix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefix[i][j] = mat[i][j]
                        + (i > 0 ? prefix[i - 1][j] : 0)
                        + (j > 0 ? prefix[i][j - 1] : 0)
                        - (i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0);
            }
        }

        int low = 1, high = Math.min(rows, cols);
        int answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (existsSquare(prefix, rows, cols, mid, threshold)) {
                answer = mid;
                low = mid + 1;   // try larger square
            } else {
                high = mid - 1;  // reduce size
            }
        }

        return answer;
    }

    // Check if there exists any square of side = len with sum <= threshold
    private boolean existsSquare(int[][] prefix, int rows, int cols,
                                 int len, int threshold) {

        for (int i = 0; i + len - 1 < rows; i++) {
            for (int j = 0; j + len - 1 < cols; j++) {
                int sum = getSum(prefix, i, j,
                                 i + len - 1,
                                 j + len - 1);
                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }

    // Sum of submatrix (r1, c1) to (r2, c2)
    private int getSum(int[][] prefix, int r1, int c1, int r2, int c2) {
        int sum = prefix[r2][c2];
        if (r1 > 0) sum -= prefix[r1 - 1][c2];
        if (c1 > 0) sum -= prefix[r2][c1 - 1];
        if (r1 > 0 && c1 > 0) sum += prefix[r1 - 1][c1 - 1];
        return sum;
    }
}
