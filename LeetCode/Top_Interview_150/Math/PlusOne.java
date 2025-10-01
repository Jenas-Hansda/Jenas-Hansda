class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++; // No carry-over needed
                return digits;
            }
            digits[i] = 0; // Carry-over, move to next digit
        }

        // If we're here, all digits were 9, so we need one extra digit
        int[] res = new int[n + 1];
        res[0] = 1; // e.g., 999 + 1 = 1000
        return res;
    }
}
