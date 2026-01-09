import java.util.List;

class SingleNumberII {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bit = 1 << i;
            int count = 0;

            for (int num : nums) {
                if ((num & bit) != 0) {
                    count++;
                }
            }

            if (count % 3 != 0) {
                result |= bit;
            }
        }

        // Handle negative numbers in Java (due to 32-bit signed int overflow)
        return result;
    }
}
