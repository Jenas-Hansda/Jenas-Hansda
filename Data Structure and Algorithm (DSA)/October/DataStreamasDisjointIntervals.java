import java.util.*;

class DataStreamasDisjointIntervals {
    private final TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>();
    }

    public void addNum(int value) {
        if (intervals.containsKey(value)) return;

        Integer lowerKey = intervals.floorKey(value);
        Integer higherKey = intervals.ceilingKey(value);

        int left = value, right = value;

        // Merge with lower interval if adjacent
        if (lowerKey != null && intervals.get(lowerKey) >= value - 1) {
            left = lowerKey;
            right = Math.max(right, intervals.get(lowerKey));
            intervals.remove(lowerKey);
        }

        // Merge with higher interval if adjacent
        if (higherKey != null && higherKey == value + 1) {
            right = intervals.get(higherKey);
            intervals.remove(higherKey);
        }

        intervals.put(left, right);
    }

    public int[][] getIntervals() {
        int[][] res = new int[intervals.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> e : intervals.entrySet()) {
            res[i][0] = e.getKey();
            res[i][1] = e.getValue();
            i++;
        }
        return res;
    }
}
