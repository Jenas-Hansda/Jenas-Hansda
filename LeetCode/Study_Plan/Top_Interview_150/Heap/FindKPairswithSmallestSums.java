import java.util.*;

class FindKPairswithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }

        // Min-heap to store entries as (sum, i, j)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Set to track visited (i, j) index pairs
        Set<String> visited = new HashSet<>();

        // Initial pair (nums1[0] + nums2[0], i=0, j=0)
        minHeap.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        visited.add("0#0");

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int sum = current[0];
            int i = current[1];
            int j = current[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            // Next pair: (i, j + 1)
            if (j + 1 < nums2.length && !visited.contains(i + "#" + (j + 1))) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(i + "#" + (j + 1));
            }

            // Next pair: (i + 1, j)
            if (i + 1 < nums1.length && !visited.contains((i + 1) + "#" + j)) {
                minHeap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add((i + 1) + "#" + j);
            }
        }

        return result;
    }
}
