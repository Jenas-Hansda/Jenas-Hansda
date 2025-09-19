import java.util.*;
public class totalCost {


public class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long totalCost = 0;

        PriorityQueue<int[]> leftHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> rightHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int left = 0, right = n - 1;

        // Fill the left and right heaps with up to 'candidates' elements
        for (int i = 0; i < candidates && left <= right; i++) {
            leftHeap.offer(new int[]{costs[left], left});
            left++;
        }

        for (int i = 0; i < candidates && left <= right; i++) {
            rightHeap.offer(new int[]{costs[right], right});
            right--;
        }

        while (k > 0) {
            if (!leftHeap.isEmpty() && (rightHeap.isEmpty() || leftHeap.peek()[0] <= rightHeap.peek()[0])) {
                int[] worker = leftHeap.poll();
                totalCost += worker[0];

                if (left <= right) {
                    leftHeap.offer(new int[]{costs[left], left});
                    left++;
                }
            } else {
                int[] worker = rightHeap.poll();
                totalCost += worker[0];

                if (left <= right) {
                    rightHeap.offer(new int[]{costs[right], right});
                    right--;
                }
            }
            k--;
        }

        return totalCost;
    }
}

}
