class DecodeWaysII {
    static final long MOD = 1000000007;

    public int numDecodings(String s) {
        int n = s.length();
        if (s.charAt(0) == '0') return 0;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '*') ? 9 : 1;

        for (int i = 2; i <= n; i++) {
            char curr = s.charAt(i - 1);
            char prev = s.charAt(i - 2);

            // 1-character decode
            if (curr == '*') {
                dp[i] = (dp[i] + 9 * dp[i - 1]) % MOD;
            } else if (curr != '0') {
                dp[i] = (dp[i] + dp[i - 1]) % MOD;
            }

            // 2-character decode
            if (prev == '*') {
                if (curr == '*') {
                    dp[i] = (dp[i] + 15 * dp[i - 2]) % MOD;
                } else if (curr <= '6') {
                    dp[i] = (dp[i] + 2 * dp[i - 2]) % MOD;
                } else {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD;
                }
            } 
            else if (prev == '1') {
                if (curr == '*') {
                    dp[i] = (dp[i] + 9 * dp[i - 2]) % MOD;
                } else {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD;
                }
            } 
            else if (prev == '2') {
                if (curr == '*') {
                    dp[i] = (dp[i] + 6 * dp[i - 2]) % MOD;
                } else if (curr <= '6') {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD;
                }
            }
        }

        return (int) dp[n];
    }
}
