class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] t = new int[n];

        for (int i = 0; i < n; i++) {
            t[i] = triangle.get(n - 1).get(i);
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                t[col] = triangle.get(row).get(col) + Math.min(t[col], t[col + 1]);
            }
        }

        return t[0];
    }
}
