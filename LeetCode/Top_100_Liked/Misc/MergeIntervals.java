import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;

        // Sort intervals by starting point
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= currentInterval[1]) {
                // Overlapping intervals: extend the current interval
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                // No overlap: add new interval
                currentInterval = interval;
                result.add(currentInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
