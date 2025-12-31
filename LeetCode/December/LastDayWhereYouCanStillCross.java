class LastDayWhereYouCanStillCross {

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;

            if (rank[px] < rank[py])
                parent[px] = py;
            else if (rank[px] > rank[py])
                parent[py] = px;
            else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int total = row * col;
        int TOP = total;
        int BOTTOM = total + 1;

        DSU dsu = new DSU(total + 2);
        boolean[][] land = new boolean[row][col];

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int day = cells.length - 1; day >= 0; day--) {
            int r = cells[day][0] - 1;
            int c = cells[day][1] - 1;
            land[r][c] = true;

            int idx = r * col + c;

            if (r == 0) dsu.union(idx, TOP);
            if (r == row - 1) dsu.union(idx, BOTTOM);

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && land[nr][nc]) {
                    dsu.union(idx, nr * col + nc);
                }
            }

            if (dsu.find(TOP) == dsu.find(BOTTOM))
                return day;
        }

        return 0;
    }
}
