import java.util.*;

class TransformedArray {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int shift = nums[i] % n; // reduce large shifts

            int newIdx = (i + shift) % n;

            if (newIdx < 0) {
                newIdx += n;
            }

            result[i] = nums[newIdx];
        }

        return result;
    }
}
