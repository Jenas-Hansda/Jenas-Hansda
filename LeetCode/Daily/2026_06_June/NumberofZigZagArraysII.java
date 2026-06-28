class Solution {

    static final long MOD = 1000000007L;

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {

                if (A[i][k] == 0) continue;

                for (int j = 0; j < n; j++) {

                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j]
                            + (A[i][k] * B[k][j]) % MOD) % MOD;
                }
            }
        }

        return C;
    }

    private long[][] power(long[][] base, long exp) {
        int n = base.length;

        long[][] result = new long[n][n];

        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }

        while (exp > 0) {

            if ((exp & 1) == 1) {
                result = multiply(result, base);
            }

            base = multiply(base, base);
            exp >>= 1;
        }

        return result;
    }

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;
        int S = 2 * m;

        long[][] T = new long[S][S];

        for (int v = 1; v <= m; v++) {

            int Uv = v - 1;
            int Dv = m + v - 1;

            for (int u = 1; u < v; u++) {
                int Du = m + u - 1;
                T[Uv][Du] = 1;
            }

            for (int u = v + 1; u <= m; u++) {
                int Uu = u - 1;
                T[Dv][Uu] = 1;
            }
        }

        long[] dp2 = new long[S];

        for (int v = 1; v <= m; v++) {
            dp2[v - 1] = v - 1;
            dp2[m + v - 1] = m - v;
        }

        long[][] P = power(T, n - 2L);

        long[] dpn = new long[S];

        for (int i = 0; i < S; i++) {
            for (int j = 0; j < S; j++) {
                dpn[i] = (dpn[i] + P[i][j] * dp2[j]) % MOD;
            }
        }

        long ans = 0;

        for (long x : dpn) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }
}