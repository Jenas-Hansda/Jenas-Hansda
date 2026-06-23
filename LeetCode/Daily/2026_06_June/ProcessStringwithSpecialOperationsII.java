class Solution {
    public char processStr(String s, long k) {
        int n = s.length();

        long L = 0;

        // Compute final length
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                if (L > 0) {
                    L--;
                }
            } else if (ch == '#') {
                L *= 2;
            } else if (ch == '%') {
                // reverse: length unchanged
            } else {
                L++;
            }
        }

        if (k >= L) {
            return '.';
        }

        // Work backwards
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '*') {
                L++;
            } else if (ch == '%') {
                k = L - k - 1;
            } else if (ch == '#') {
                L /= 2;
                if (k >= L) {
                    k -= L;
                }
            } else {
                L--;
            }

            if (k == L) {
                return ch;
            }
        }

        return '.';
    }
}