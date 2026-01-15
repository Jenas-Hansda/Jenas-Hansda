import java.util.*;

class MaximumAreaofSquareHoleinGrid {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        // Step 1: Sort the bars
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxConsecutiveHBars = 1;
        int maxConsecutiveVBars = 1;

        // Find longest consecutive horizontal bars
        int currConsecutiveHBars = 1;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] - hBars[i - 1] == 1) {
                currConsecutiveHBars++;
            } else {
                currConsecutiveHBars = 1;
            }
            maxConsecutiveHBars = Math.max(maxConsecutiveHBars, currConsecutiveHBars);
        }

        // Find longest consecutive vertical bars
        int currConsecutiveVBars = 1;
        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] - vBars[i - 1] == 1) {
                currConsecutiveVBars++;
            } else {
                currConsecutiveVBars = 1;
            }
            maxConsecutiveVBars = Math.max(maxConsecutiveVBars, currConsecutiveVBars);
        }

        // Square side length
        int side = Math.min(maxConsecutiveHBars, maxConsecutiveVBars) + 1;

        return side * side;
    }
}
