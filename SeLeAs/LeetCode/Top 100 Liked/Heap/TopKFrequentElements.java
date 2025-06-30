import java.util.*;

public class TopKFrequentElements{
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min-heap to keep top k frequent elements
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0]) // compare by frequency
        );

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Step 3: Extract results into an int[]
        int[] result = new int[k];
        int index = 0;
        while (!heap.isEmpty()) {
            result[index++] = heap.poll()[1];
        }

        return result;
    }
}
}