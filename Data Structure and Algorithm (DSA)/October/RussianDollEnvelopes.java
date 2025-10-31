import java.util.*;

class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;

        // Step 1: Sort envelopes
        // Width ascending, height descending for same width
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        // Step 2: Find LIS (Longest Increasing Subsequence) on heights
        int[] dp = new int[envelopes.length];
        int maxlen = 0;

        for (int[] envelope : envelopes) {
            int height = envelope[1];

            // Find the index to replace or insert using binary search
            int index = Arrays.binarySearch(dp, 0, maxlen, height);

            // If not found, Arrays.binarySearch returns (-(insertion point) - 1)
            if (index < 0) index = -(index + 1);

            dp[index] = height;

            // If height is greater than all in dp, extend LIS length
            if (index == maxlen) maxlen++;
        }

        return maxlen;
    }
}
