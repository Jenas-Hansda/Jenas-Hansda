class LongestIncreasingPathinaMatrix {
    private int[][] helper;
    private int n, m;
    
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        helper = new int[n][m];
        int maxPath = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxPath = Math.max(maxPath, solve(matrix, i, j, -1));
            }
        }
        return maxPath;
    }
    
    private int solve(int[][] mat, int i, int j, int prev) {
        if (i < 0 || j < 0 || i >= n || j >= m || mat[i][j] <= prev)
            return 0;
        
        if (helper[i][j] != 0)
            return helper[i][j];
        
        int val = mat[i][j];
        
        helper[i][j] = 1 + Math.max(
            Math.max(solve(mat, i + 1, j, val), solve(mat, i - 1, j, val)),
            Math.max(solve(mat, i, j + 1, val), solve(mat, i, j - 1, val))
        );
        
        return helper[i][j];
    }
}
