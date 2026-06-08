import java.util.*;

class Solution {

    private String s;
    private Map<Long, long[]> memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x <= 0) return 0;

        s = String.valueOf(x);
        memo = new HashMap<>();

        return dfs(0, -1, -1, true, false)[1];
    }

    // returns {countNumbers, totalWaviness}
    private long[] dfs(int pos,
                       int prev2,
                       int prev1,
                       boolean tight,
                       boolean started) {

        if (pos == s.length()) {
            return new long[]{1, 0};
        }

        if (!tight) {
            long key = encode(pos, prev2, prev1, started);
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            long[] ans = compute(pos, prev2, prev1, false, started);
            memo.put(key, ans);
            return ans;
        }

        return compute(pos, prev2, prev1, true, started);
    }

    private long[] compute(int pos,
                           int prev2,
                           int prev1,
                           boolean tight,
                           boolean started) {

        int limit = tight ? s.charAt(pos) - '0' : 9;

        long count = 0;
        long totalWave = 0;

        for (int d = 0; d <= limit; d++) {

            boolean nextTight = tight && (d == limit);

            if (!started && d == 0) {
                long[] nxt = dfs(pos + 1, -1, -1, nextTight, false);

                count += nxt[0];
                totalWave += nxt[1];
            } else {

                int add = 0;

                if (prev2 != -1) {
                    if ((prev2 < prev1 && prev1 > d) ||
                        (prev2 > prev1 && prev1 < d)) {
                        add = 1;
                    }
                }

                long[] nxt = dfs(pos + 1, prev1, d, nextTight, true);

                count += nxt[0];
                totalWave += nxt[1] + add * nxt[0];
            }
        }

        return new long[]{count, totalWave};
    }

    private long encode(int pos, int prev2, int prev1, boolean started) {
        long key = pos;
        key = key * 12 + (prev2 + 1);
        key = key * 12 + (prev1 + 1);
        key = key * 2 + (started ? 1 : 0);
        return key;
    }
}