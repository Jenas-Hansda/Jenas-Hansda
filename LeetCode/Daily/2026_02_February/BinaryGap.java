class BinaryGap {
    public int binaryGap(int n) {
        int prev = -1;
        int result = 0;

        for (int curr = 0; curr < 32; curr++) {
            if (((n >> curr) & 1) == 1) {
                if (prev != -1) {
                    result = Math.max(result, curr - prev);
                }
                prev = curr;
            }
        }

        return result;
    }
}