class ConstructQuadTree {
    
    public boolean isAllSame(int[][] grid, int x, int y, int n) {
        int val = grid[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }

    public Node solve(int[][] grid, int x, int y, int n) {
        if (isAllSame(grid, x, y, n)) {
            return new Node(grid[x][y] == 1, true);
        }

        int half = n / 2;
        
        Node topLeft = solve(grid, x, y, half);
        Node topRight = solve(grid, x, y + half, half);
        Node bottomLeft = solve(grid, x + half, y, half);
        Node bottomRight = solve(grid, x + half, y + half, half);

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public Node construct(int[][] grid) {
        return solve(grid, 0, 0, grid.length);
    }
}
