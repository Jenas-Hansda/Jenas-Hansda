class MaximumRunningTimeofNComputers {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;

        long left = 0, right = sum / n, result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canRun(batteries, n, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private boolean canRun(int[] batteries, int n, long time) {
        long total = 0;
        for (long b : batteries) {
            total += Math.min(b, time);
            if (total >= time * n) return true;
        }
        return total >= time * n;
    }
}
