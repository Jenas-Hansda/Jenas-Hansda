class MinimumDeletionstoMakeStringBalanced {
    public int minimumDeletions(String s) {
        int n = s.length();

        // Count total number of 'a' characters
        int countA = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'a') {
                countA++;
            }
        }

        int countB = 0;
        int result = Integer.MAX_VALUE;

        // Traverse from left to right
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                countA--; // this 'a' is now on the left side
            }

            // deletions = b's on left + a's on right
            result = Math.min(result, countB + countA);

            if (s.charAt(i) == 'b') {
                countB++;
            }
        }

        return result;
    }
}
