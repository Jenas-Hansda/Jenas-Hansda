class RepeatandMissingNumber {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long N = (long) n * n;

        long gridSum = 0;
        long gridSqSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long val = grid[i][j];
                gridSum += val;
                gridSqSum += val * val;
            }
        }

        long expectedSum = (N * (N + 1)) / 2;
        long expectedSqSum = (N * (N + 1) * (2 * N + 1)) / 6;

        long sumDiff = gridSum - expectedSum;       // x - y
        long sqDiff = gridSqSum - expectedSqSum;    // x^2 - y^2 = (x - y)(x + y)

        long sumPlus = sqDiff / sumDiff;            // x + y

        int repeated = (int) ((sumPlus + sumDiff) / 2);
        int missing = (int) ((sumPlus - sumDiff) / 2);

        return new int[]{repeated, missing };
    }
}
