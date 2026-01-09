import java.util.*;

class CountCoveredBuildings {
    public int countCoveredBuildings(int n, int[][] buildings) {

        Map<Integer, int[]> yToMinMaxX = new HashMap<>();
        Map<Integer, int[]> xToMinMaxY = new HashMap<>();

        // First pass: record min/max x for each y, and min/max y for each x
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];

            yToMinMaxX.putIfAbsent(y, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            xToMinMaxY.putIfAbsent(x, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});

            int[] xr = yToMinMaxX.get(y);
            int[] yr = xToMinMaxY.get(x);

            xr[0] = Math.min(xr[0], x);
            xr[1] = Math.max(xr[1], x);

            yr[0] = Math.min(yr[0], y);
            yr[1] = Math.max(yr[1], y);
        }

        int result = 0;

        // Second pass: count buildings strictly inside both min/max ranges
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];

            int[] xr = yToMinMaxX.get(y);
            int[] yr = xToMinMaxY.get(x);

            if (xr[0] < x && x < xr[1] && 
                yr[0] < y && y < yr[1]) {
                result++;
            }
        }

        return result;
    }
}
