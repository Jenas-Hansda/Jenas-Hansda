import java.util.Arrays;

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        // Create a sorted copy of nums
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        // Try every possible rotation
        for (int r = 0; r < n; r++) {
            boolean isSorted = true;

            for (int i = 0; i < n; i++) {
                // Compare sorted array with rotated version of nums
                if (sorted[i] != nums[(i + r) % n]) {
                    isSorted = false;
                    break;
                }
            }

            if (isSorted) {
                return true;
            }
        }

        return false;
    }
}