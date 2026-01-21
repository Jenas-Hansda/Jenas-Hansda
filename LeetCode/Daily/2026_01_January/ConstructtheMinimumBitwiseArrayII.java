import java.util.*;

class ConstructtheMinimumBitwiseArrayII {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
        int idx = 0;

        for (int num : nums) {

            // Special case
            if (num == 2) {
                result[idx++] = -1;
                continue;
            }

            boolean found = false;

            // Check bits from 1 to 31
            for (int j = 1; j < 32; j++) {

                // If j-th bit is set, skip
                if ((num & (1 << j)) != 0) {
                    continue;
                }

                // Found an unset bit at position j
                // Toggle (j-1)-th bit
                result[idx++] = num ^ (1 << (j - 1));
                found = true;
                break;
            }

            if (!found) {
                result[idx++] = -1;
            }
        }

        return result;
    }
}
