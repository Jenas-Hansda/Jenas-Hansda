class FindAllPossibleStableBinaryArraysI {
    int M = (int)1e9 + 7;

    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] dp = new int[one + 1][zero + 1][2];

        // Base case: solve(0,0,lastWasOne) = 1
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;

        for (int onesLeft = 0; onesLeft <= one; onesLeft++) {
            for (int zerosLeft = 0; zerosLeft <= zero; zerosLeft++) {
                if (onesLeft == 0 && zerosLeft == 0) continue;

                // lastWasOne == true (1): we can place 0s
                int res = 0;
                for (int len = 1; len <= Math.min(zerosLeft, limit); len++) {
                    res = (res + dp[onesLeft][zerosLeft - len][0]) % M;
                }
                dp[onesLeft][zerosLeft][1] = res;

                // lastWasOne == false (0): we can place 1s
                res = 0;
                for (int len = 1; len <= Math.min(onesLeft, limit); len++) {
                    res = (res + dp[onesLeft - len][zerosLeft][1]) % M;
                }
                dp[onesLeft][zerosLeft][0] = res;
            }
        }

        // Result: starting with a 1 or starting with a 0
        int startWithOne = dp[one][zero][0];
        int startWithZero = dp[one][zero][1];

        return (startWithOne + startWithZero) % M;
    }
}