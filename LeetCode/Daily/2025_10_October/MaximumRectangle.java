// Efficient solution to find the largest rectangle of 1's in a binary matrix
class MaximumRectangle {

    // Function to calculate Maximum Area in Histogram (MAH) for a given heights array
    public int MAH(int[] heights, int n) {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int maxArea = 0;
        int area = 0;

        // Traverse through all bars of the histogram
        while (i < n) {
            // If the current bar is higher or equal to the bar at stack top, push it
            if (st.isEmpty() || heights[i] >= heights[st.peek()]) {
                st.push(i++);
            } else {
                // Pop the top bar and calculate area with the popped bar as the smallest bar
                int index = st.pop();

                // If stack is empty, width = i (all elements before current are greater)
                if (st.isEmpty()) {
                    area = heights[index] * i;
                } else {
                    // Width = distance between current index and stack top index - 1
                    area = heights[index] * (i - st.peek() - 1);
                }

                // Update max area if needed
                maxArea = Math.max(maxArea, area);
            }
        }

        // Compute area for remaining bars in the stack
        while (!st.isEmpty()) {
            int index = st.pop();

            if (st.isEmpty()) {
                area = heights[index] * i;
            } else {
                area = heights[index] * (i - st.peek() - 1);
            }

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    // Main function to find the maximal rectangle of 1's in a binary matrix
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int maxArea = 0;
        int m = matrix.length;    // number of rows
        int n = matrix[0].length; // number of columns

        // Create an array to store heights of histogram (one for each column)
        int[] heights = new int[n];

        // Convert the first row into the histogram base
        for (int col = 0; col < n; col++) {
            heights[col] = matrix[0][col] == '0' ? 0 : 1;
        }

        // Compute area for the first row
        maxArea = MAH(heights, n);

        // Process each row from the second row onwards
        for (int row = 1; row < m; row++) {
            for (int col = 0; col < n; col++) {
                // If current cell is '0', reset height to 0
                if (matrix[row][col] == '0') {
                    heights[col] = 0;
                } else {
                    // If '1', increase the height (accumulate from previous row)
                    heights[col] += 1;
                }
            }

            // Calculate max area for current histogram
            maxArea = Math.max(maxArea, MAH(heights, n));
        }

        return maxArea;
    }
}
