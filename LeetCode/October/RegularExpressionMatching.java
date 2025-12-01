class RegularExpressionMatching {
    // Memoization table: t[i][j] stores result of solve(i, j)
    // 1 = true, 0 = false, -1 = not yet computed
    int[][] t;

    // Recursive function to check if s[i:] matches p[j:]
    public boolean solve(int i, int j, String s, String p) {
        // Base case: if we've reached the end of the pattern
        if (j == p.length()) {
            // Match is successful only if we also reached the end of the string
            return i == s.length();
        }

        // Return cached result if already computed
        if (t[i][j] != -1) {
            return t[i][j] == 1;
        }

        boolean ans = false;

        // Check if current characters match or if pattern has '.'
        boolean first_match = (i < s.length() &&
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

        // Handle '*' in the pattern (zero or more of preceding character)
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Two choices:
            // 1. Skip '*' and the previous character (zero occurrence)
            // 2. If first characters match, try to match one more character in s
            ans = (solve(i, j + 2, s, p) ||
                   (first_match && solve(i + 1, j, s, p)));
        } else {
            // No '*', so proceed with regular character match
            ans = first_match && solve(i + 1, j + 1, s, p);
        }

        // Store result in memo table and return
        return (t[i][j] = ans ? 1 : 0) == 1;
    }

    // Public method to initiate the matching process
    public boolean isMatch(String s, String p) {
        // Initialize memoization table with -1 (uncomputed)
        // Assumes max input size is 20; update if needed for larger inputs
        t = new int[21][21];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        // Start recursion from beginning of both s and p
        return solve(0, 0, s, p);
    }
}
