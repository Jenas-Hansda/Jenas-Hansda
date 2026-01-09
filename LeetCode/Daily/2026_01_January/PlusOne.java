// Approach (Simple follow Math Addition Principles)
// T.C : O(n)
// S.C : O(1)
class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        int i = n - 1; // Start from LSB like usual math addition

        while (i >= 0) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }

            // else we did get 9
            digits[i] = 0; // 9 + 1 = 10
            i--;
        }

        // If carry is forwarded till the end
        int[] result = new int[n + 1];
        result[0] = 1; // leading carry

        return result;
    }
}
