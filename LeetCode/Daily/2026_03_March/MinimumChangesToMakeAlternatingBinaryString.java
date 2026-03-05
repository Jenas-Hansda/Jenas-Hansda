class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        int n = s.length();
        int startWith0 = 0;

        // pattern: 010101...
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') {
                    startWith0++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    startWith0++;
                }
            }
        }

        return Math.min(startWith0, n - startWith0);
    }
}