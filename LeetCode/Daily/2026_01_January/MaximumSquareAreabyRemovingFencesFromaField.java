import java.util.*;

class MaximumSquareAreabyRemovingFencesFromaField {
    private static final int MOD = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        // Create new arrays with boundary fences added
        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];

        System.arraycopy(hFences, 0, h, 0, hFences.length);
        System.arraycopy(vFences, 0, v, 0, vFences.length);

        h[hFences.length] = 1;
        h[hFences.length + 1] = m;

        v[vFences.length] = 1;
        v[vFences.length + 1] = n;

        // Sort fences
        Arrays.sort(h);
        Arrays.sort(v);

        // Store all possible widths
        HashSet<Integer> widths = new HashSet<>();

        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                widths.add(v[j] - v[i]);
            }
        }

        int maxSide = 0;

        // Check matching heights
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                int height = h[j] - h[i];
                if (widths.contains(height)) {
                    maxSide = Math.max(maxSide, height);
                }
            }
        }

        return maxSide == 0 ? -1 : (int) ((1L * maxSide * maxSide) % MOD);
    }
}
