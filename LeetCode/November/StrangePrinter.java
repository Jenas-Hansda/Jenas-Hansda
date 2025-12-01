class StrangePrinter {

    int n;
    int[][] t;

    int solve(int l, int r, String s) {
        if (l == r)
            return 1;
        if (l > r)
            return 0;

        if (t[l][r] != -1)
            return t[l][r];

        int i = l + 1;
        while (i <= r && s.charAt(i) == s.charAt(l))
            i++;

        if (i == r + 1)
            return t[l][r] = 1;

        int normal = 1 + solve(i, r, s);

        int best = Integer.MAX_VALUE;

        for (int j = i; j <= r; j++) {
            if (s.charAt(l) == s.charAt(j)) {
                int x = solve(i, j - 1, s) + solve(j, r, s);
                best = Math.min(best, x);
            }
        }

        return t[l][r] = Math.min(best, normal);
    }

    public int strangePrinter(String s) {
        n = s.length();
        t = new int[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(t[i], -1);

        return solve(0, n - 1, s);
    }
}
