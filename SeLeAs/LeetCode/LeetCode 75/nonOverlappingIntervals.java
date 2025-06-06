import java.util.Arrays;
import java.util.Comparator;

public class nonOverlappingIntervals {
    class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort intervals by end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int remove = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                remove++; // Overlapping interval
            } else {
                end = intervals[i][1]; // Update end to current interval's end
            }
        }

        return remove;
    }
}
}