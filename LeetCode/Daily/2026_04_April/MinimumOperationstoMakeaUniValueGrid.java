import java.util.Arrays;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        int[] arr = new int[m * n];
        int idx = 0;

        // Flatten the grid
        for (int[] row : grid) {
            for (int num : row) {
                arr[idx++] = num;
            }
        }

        // Check if all elements have same remainder mod x
        int mod = arr[0] % x;
        for (int num : arr) {
            if (num % x != mod) {
                return -1;
            }
        }

        // Sort array
        Arrays.sort(arr);

        // Take median
        int median = arr[arr.length / 2];

        // Calculate operations
        int operations = 0;
        for (int num : arr) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}