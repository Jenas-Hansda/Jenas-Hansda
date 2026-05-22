import java.util.*;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet<>();

        // Store all prefixes from arr1
        for (int val : arr1) {
            while (val > 0 && !prefixes.contains(val)) {
                prefixes.add(val);
                val /= 10;
            }
        }

        int ans = 0;

        // Find longest matching prefix in arr2
        for (int val : arr2) {
            while (val > 0 && !prefixes.contains(val)) {
                val /= 10;
            }

            if (val > 0) {
                ans = Math.max(ans, String.valueOf(val).length());
            }
        }

        return ans;
    }
}