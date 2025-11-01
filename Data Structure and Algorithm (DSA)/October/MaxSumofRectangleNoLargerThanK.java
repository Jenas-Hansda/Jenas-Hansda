import java.util.*;

class MaxSumofRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        int res = Integer.MIN_VALUE;

        for (int left = 0; left < cols; ++left) {
            int[] rowSums = new int[rows];

            for (int right = left; right < cols; ++right) {
                // accumulate sums for each row between columns [left, right]
                for (int i = 0; i < rows; ++i) {
                    rowSums[i] += matrix[i][right];
                }

                // use TreeSet to find the prefix sum close to (currentSum - k)
                TreeSet<Integer> prefixSums = new TreeSet<>();
                prefixSums.add(0);
                int runningSum = 0;

                for (int sum : rowSums) {
                    runningSum += sum;
                    // find smallest prefix >= runningSum - k
                    Integer target = prefixSums.ceiling(runningSum - k);
                    if (target != null) {
                        res = Math.max(res, runningSum - target);
                    }
                    prefixSums.add(runningSum);
                }
            }
        }
        return res;
    }
}
