class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        long sum = 0;
        int countNegatives = 0;
        int smallestAbsoluteValue = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];

                sum += Math.abs(val);

                if (val < 0) {
                    countNegatives++;
                }

                smallestAbsoluteValue = Math.min(
                    smallestAbsoluteValue,
                    Math.abs(val)
                );
            }
        }

        if (countNegatives % 2 == 0) {
            return sum;
        }

        return sum - 2L * smallestAbsoluteValue;
    }
}
