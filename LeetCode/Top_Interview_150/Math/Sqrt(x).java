class Sqrt(x) {
    public int mySqrt(int x) {
        if (x < 2) return x;  // handle 0 and 1 directly

        int left = 1;
        int right = x / 2 + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }
}
