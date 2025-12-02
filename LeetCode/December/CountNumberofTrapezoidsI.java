import java.util.*;

class Solution {
    final long M = 1000000007L;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> mp = new HashMap<>();  // y -> count of points at y

        for (int[] point : points) {
            int y = point[1];
            mp.put(y, mp.getOrDefault(y, 0) + 1);
        }

        long result = 0;
        long prevHorizontalLines = 0;

        for (int count : mp.values()) {
            long horizontalLines = (long) count * (count - 1) / 2;

            result = (result + horizontalLines * prevHorizontalLines) % M;

            prevHorizontalLines = (prevHorizontalLines + horizontalLines) % M;
        }

        return (int) result;
    }
}
