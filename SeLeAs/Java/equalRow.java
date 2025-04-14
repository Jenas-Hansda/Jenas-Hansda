import java.util.*;

class equalRow {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int pairs = 0;
        
        // Map to store the frequency of each row as a list
        Map<List<Integer>, Integer> rows = new HashMap<>();
        
        // Count occurrences of each row
        for (int[] row : grid) {
            List<Integer> rowList = new ArrayList<>();
            for (int val : row) {
                rowList.add(val);
            }
            rows.put(rowList, rows.getOrDefault(rowList, 0) + 1);
        }
        
        // Check each column
        for (int col = 0; col < n; col++) {
            List<Integer> columnList = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                columnList.add(grid[row][col]);
            }
            if (rows.containsKey(columnList)) {
                pairs += rows.get(columnList);
            }
        }
        
        return pairs;
    }
}
