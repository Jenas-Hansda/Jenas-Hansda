class MinimumNumberofFlipstoMaketheBinaryStringAlternating {
    public int minFlips(String s) {

        int n = s.length();
        int ans = Integer.MAX_VALUE;

        int startWithZero = 0;
        int startWithOne = 0;

        for (int i = 0; i < 2 * n; i++) {

            char ch = s.charAt(i % n);

            if (i % 2 == 0) {
                if (ch == '1') startWithZero++;
                else startWithOne++;
            } else {
                if (ch == '0') startWithZero++;
                else startWithOne++;
            }

            if (i >= n - 1) {
                ans = Math.min(ans, Math.min(startWithZero, startWithOne));

                int prev = i - n + 1;
                char prevChar = s.charAt(prev % n);

                if (prev % 2 == 0) {
                    if (prevChar == '1') startWithZero--;
                    else startWithOne--;
                } else {
                    if (prevChar == '0') startWithZero--;
                    else startWithOne--;
                }
            }
        }

        return ans;
    }
}