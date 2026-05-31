import java.util.*;

class Solution {

    private int[] segmentTree;
    private final int N = 50000;

    private void buildSegmentTree() {
        segmentTree = new int[4 * N];
    }

    private void update(int idx, int val, int node, int left, int right) {
        if (left == right) {
            segmentTree[node] = val;
            return;
        }

        int mid = left + (right - left) / 2;

        if (idx <= mid) {
            update(idx, val, 2 * node + 1, left, mid);
        } else {
            update(idx, val, 2 * node + 2, mid + 1, right);
        }

        segmentTree[node] = Math.max(
                segmentTree[2 * node + 1],
                segmentTree[2 * node + 2]
        );
    }

    private int query(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left >= start && right <= end) {
            return segmentTree[node];
        }

        int mid = left + (right - left) / 2;

        return Math.max(
                query(start, end, 2 * node + 1, left, mid),
                query(start, end, 2 * node + 2, mid + 1, right)
        );
    }

    public List<Boolean> getResults(int[][] queries) {
        buildSegmentTree();

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);

        List<Boolean> result = new ArrayList<>();

        for (int[] query : queries) {

            if (query[0] == 1) {
                int x = query[1];

                Integer nxt = obstacles.higher(x);
                Integer pre = obstacles.lower(x);

                update(x, x - pre, 0, 0, N - 1);

                if (nxt != null) {
                    update(nxt, nxt - x, 0, 0, N - 1);
                }

                obstacles.add(x);

            } else {
                int x = query[1];
                int sz = query[2];

                Integer pre = obstacles.lower(x + 1); // largest obstacle <= x

                int maxGap = query(0, pre, 0, 0, N - 1);
                int best = Math.max(maxGap, x - pre);

                result.add(best >= sz);
            }
        }

        return result;
    }
}