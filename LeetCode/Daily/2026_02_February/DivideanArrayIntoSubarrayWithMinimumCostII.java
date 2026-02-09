import java.util.*;

class DivideanArrayIntoSubarrayWithMinimumCostII {

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        // TreeSet storing {value, index}
        TreeSet<long[]> kMinimum = new TreeSet<>(
            (a, b) -> {
                if (a[0] != b[0]) return Long.compare(a[0], b[0]);
                return Long.compare(a[1], b[1]);
            }
        );

        TreeSet<long[]> remaining = new TreeSet<>(
            (a, b) -> {
                if (a[0] != b[0]) return Long.compare(a[0], b[0]);
                return Long.compare(a[1], b[1]);
            }
        );

        long sum = 0; // sum of (k-1) minimum elements

        int i = 1;
        while (i - dist < 1) {
            long[] cur = new long[]{nums[i], i};
            kMinimum.add(cur);
            sum += nums[i];

            if (kMinimum.size() > k - 1) {
                long[] temp = kMinimum.last();
                sum -= temp[0];
                remaining.add(temp);
                kMinimum.remove(temp);
            }
            i++;
        }

        long result = Long.MAX_VALUE;

        while (i < n) {
            long[] cur = new long[]{nums[i], i};
            kMinimum.add(cur);
            sum += nums[i];

            if (kMinimum.size() > k - 1) {
                long[] temp = kMinimum.last();
                sum -= temp[0];
                remaining.add(temp);
                kMinimum.remove(temp);
            }

            result = Math.min(result, sum);

            // Remove element going out of window
            long[] remove = new long[]{nums[i - dist], i - dist};

            if (kMinimum.contains(remove)) {
                kMinimum.remove(remove);
                sum -= remove[0];

                if (!remaining.isEmpty()) {
                    long[] temp = remaining.first();
                    kMinimum.add(temp);
                    sum += temp[0];
                    remaining.remove(temp);
                }
            } else {
                remaining.remove(remove);
            }

            i++;
        }

        return nums[0] + result;
    }
}
