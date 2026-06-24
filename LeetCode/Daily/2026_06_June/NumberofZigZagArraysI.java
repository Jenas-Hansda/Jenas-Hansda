class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        if (n == 1) {
            return m % (int) MOD;
        }

        long[] up = new long[m + 1];
        long[] down = new long[m + 1];

        // Base case: length = 2
        for (int v = 1; v <= m; v++) {
            up[v] = v - 1;     // previous value smaller
            down[v] = m - v;   // previous value larger
        }

        for (int len = 3; len <= n; len++) {

            long[] newUp = new long[m + 1];
            long[] newDown = new long[m + 1];

            long pref = 0;
            for (int v = 1; v <= m; v++) {
                newUp[v] = pref;
                pref = (pref + down[v]) % MOD;
            }

            long suff = 0;
            for (int v = m; v >= 1; v--) {
                newDown[v] = suff;
                suff = (suff + up[v]) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int v = 1; v <= m; v++) {
            ans = (ans + up[v] + down[v]) % MOD;
        }

        return (int) ans;
    }
}