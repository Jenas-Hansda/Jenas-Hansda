public class domino{
    class Solution {
    public int numTilings(int N) {
        int md = 1_000_000_007;
        long[] v = new long[Math.max(1001, N + 1)];
        v[1] = 1;
        v[2] = 2;
        v[3] = 5;
        if (N <= 3) {
            return (int) v[N];
        }
        for (int i = 4; i <= N; ++i) {
            v[i] = (2L * v[i - 1] + v[i - 3]) % md;
        }
        return (int) v[N];
    }
}

}