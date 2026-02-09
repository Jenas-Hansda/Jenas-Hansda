class StringtoInteger(atoi) {
    public int myAtoi(String s) {
        if (s == null) return 0;

        int n = s.length();
        int i = 0;

        // Trim leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n) return 0;

        int sign = 1;
        long ans = 0;

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        while (i < n) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) break;

            ans = ans * 10 + (c - '0');

            // Overflow checks
            if (sign == -1 && -ans < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if (sign == 1 && ans > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            i++;
        }

        return (int)(sign * ans);
    }
}
