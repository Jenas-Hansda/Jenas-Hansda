import java.util.*;

public class maxScore {
    public long MaxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        // Create array of pairs
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        // Sort pairs in descending order of nums2 (second element)
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[1], a[1]));

        long maxScore = 0;
        long currSum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min-heap for nums1 values

        for (int[] pair : pairs) {
            int n1 = pair[0];
            int n2 = pair[1];

            minHeap.add(n1);
            currSum += n1;

            if (minHeap.size() > k) {
                currSum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, currSum * n2);
            }
        }

        return maxScore;
    }
}
