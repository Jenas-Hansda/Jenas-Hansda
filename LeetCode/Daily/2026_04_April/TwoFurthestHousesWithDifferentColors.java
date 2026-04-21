class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int max = 0;

        // Compare with first element
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                max = i;
                break;
            }
        }

        // Compare with last element
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                max = Math.max(max, n - 1 - i);
                break;
            }
        }

        return max;
    }
}