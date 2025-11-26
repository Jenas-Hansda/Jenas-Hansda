class KthSmallestNumberinMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        long low = 1, high = (long) m * n;

        while (low < high) {
            long mid = low + (high - low) / 2;
            int cnt = count(mid, m, n);

            if (cnt >= k) high = mid;
            else low = mid + 1;
        }

        return (int) low;
    }

    private int count(long mid, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min((int)(mid / i), n);
        }
        return count;
    }
}
