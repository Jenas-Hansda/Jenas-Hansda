class Solution {
    int[][][] dp = new int[301][27][27];

    // Convert position (0–25) to grid coordinates
    int[] getCoord(int pos) {
        return new int[]{pos / 6, pos % 6};
    }

    // Manhattan distance between two characters
    int getDistance(int pos1, int pos2) {
        if (pos1 == 26 || pos2 == 26) return 0; // unused finger

        int[] c1 = getCoord(pos1);
        int[] c2 = getCoord(pos2);

        return Math.abs(c1[0] - c2[0]) + Math.abs(c1[1] - c2[1]);
    }

    int solve(String word, int i, int f1, int f2) {
        if (i >= word.length()) return 0;

        if (dp[i][f1][f2] != -1) return dp[i][f1][f2];

        int curr = word.charAt(i) - 'A';

        // Both fingers unused
        if (f1 == 26 && f2 == 26) {
            return dp[i][f1][f2] = solve(word, i + 1, curr, f2);
        }

        // Second finger unused
        if (f2 == 26) {
            int moveF2 = solve(word, i + 1, f1, curr);
            int moveF1 = getDistance(f1, curr) + solve(word, i + 1, curr, f2);

            return dp[i][f1][f2] = Math.min(moveF1, moveF2);
        }

        // Both fingers used
        int moveF1 = getDistance(f1, curr) + solve(word, i + 1, curr, f2);
        int moveF2 = getDistance(f2, curr) + solve(word, i + 1, f1, curr);

        return dp[i][f1][f2] = Math.min(moveF1, moveF2);
    }

    public int minimumDistance(String word) {
        // Initialize DP with -1
        for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 27; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(word, 0, 26, 26);
    }
}