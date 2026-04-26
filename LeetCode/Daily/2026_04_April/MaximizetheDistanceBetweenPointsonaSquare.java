import java.util.*;

class Solution {

    boolean check(int n, List<Long> res, int k, int side) {
        int m = res.size();
        int[] idx = new int[k];

        long curr = res.get(0);
        idx[0] = 0;

        for (int i = 1; i < k; i++) {
            int it = lowerBound(res, curr + n);
            if (it == m)
                return false;
            idx[i] = it;
            curr = res.get(it);
        }

        if (res.get(idx[k - 1]) - res.get(0) <= (long) side * 4 - n)
            return true;

        for (idx[0] = 1; idx[0] < idx[1]; idx[0]++) {
            for (int j = 1; j < k; j++) {
                while (idx[j] < m && res.get(idx[j]) < res.get(idx[j - 1]) + n) {
                    idx[j]++;
                }
                if (idx[j] == m)
                    return false;
            }
            if (res.get(idx[k - 1]) - res.get(idx[0]) <= (long) side * 4 - n)
                return true;
        }
        return false;
    }

    public int maxDistance(int side, int[][] points, int k) {
        List<Long> res = new ArrayList<>();

        for (int[] p : points) {
            int x = p[0], y = p[1];
            if (x == 0)
                res.add((long) y);
            else if (y == side)
                res.add((long) side + x);
            else if (x == side)
                res.add((long) side * 3 - y);
            else
                res.add((long) side * 4 - x);
        }

        Collections.sort(res);

        int left = 1;
        int right = (int) ((long) side * 4 / k) + 1;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, res, k, side)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // Equivalent to lower_bound
    private int lowerBound(List<Long> res, long target) {
        int left = 0, right = res.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (res.get(mid) < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}