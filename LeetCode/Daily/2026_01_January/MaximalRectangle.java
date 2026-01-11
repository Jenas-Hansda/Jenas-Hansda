import java.util.*;

class MaximalRectangle {

    // Maximum Area Histogram (MAH)
    private int MAH(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        int n = heights.length;

        while (i < n) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int index = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = heights[index] * width;
                maxArea = Math.max(maxArea, area);
            }
        }

        // Remaining bars
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            int area = heights[index] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;

        int[] heights = new int[cols];

        // Initialize first row
        for (int col = 0; col < cols; col++) {
            heights[col] = matrix[0][col] == '1' ? 1 : 0;
        }

        maxArea = MAH(heights);

        // Process remaining rows
        for (int row = 1; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '0') {
                    heights[col] = 0;
                } else {
                    heights[col] += 1;
                }
            }
            maxArea = Math.max(maxArea, MAH(heights));
        }

        return maxArea;
    }
}
