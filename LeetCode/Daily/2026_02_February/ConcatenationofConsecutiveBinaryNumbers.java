class ConcatenationofConsecutiveBinaryNumbers {
    public int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;
        long result = 0;
        int digits = 0;

        for (int num = 1; num <= n; num++) {

            // digits increase only when num is a power of 2
            if ((num & (num - 1)) == 0) {
                digits++;
            }

            result = ((result << digits) % MOD + num) % MOD;
        }

        return (int) result;
    }
}