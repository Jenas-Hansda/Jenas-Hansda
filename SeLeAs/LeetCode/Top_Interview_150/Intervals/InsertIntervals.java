package Top_Interview_150.Intervals;
import java.util.Arrays;

public class InsertIntervals {
    

public class InsertInterval {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals == null || intervals.length == 0) {
      return new int[][] { newInterval };
    }

    int[][] result = new int[intervals.length + 1][2];
    int i = 0, j = 0;

    // Add all intervals that end before the new interval starts
    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
      result[j++] = intervals[i++];
    }

    // Merge overlapping intervals with the new interval
    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
    }

    result[j++] = newInterval;

    // Add all remaining intervals
    while (i < intervals.length) {
      result[j++] = intervals[i++];
    }

    return Arrays.copyOf(result, j);
  }
}

}
