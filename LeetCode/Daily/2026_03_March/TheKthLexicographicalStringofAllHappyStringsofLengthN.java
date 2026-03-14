class TheKthLexicographicalStringofAllHappyStringsofLengthN {

    public void solve(int n, StringBuilder curr, int[] count, int k, StringBuilder result) {
        if (curr.length() == n) {
            count[0]++;

            if (count[0] == k) {
                result.append(curr.toString());
            }
            return;
        }

        for (char ch = 'a'; ch <= 'c'; ch++) {

            if (curr.length() > 0 && curr.charAt(curr.length() - 1) == ch)
                continue;

            // Do
            curr.append(ch);

            // Explore
            solve(n, curr, count, k, result);

            // If result found → stop recursion
            if (result.length() != 0)
                return;

            // Undo
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public String getHappyString(int n, int k) {

        StringBuilder curr = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int[] count = new int[1];

        solve(n, curr, count, k, result);

        return result.toString();
    }
}