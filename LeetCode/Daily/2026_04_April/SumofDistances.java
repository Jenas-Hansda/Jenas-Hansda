import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;

        long[] arr = new long[n];

        Map<Integer, Long> indexSum = new HashMap<>();
        Map<Integer, Long> indexCount = new HashMap<>();

        // Left to Right
        for (int i = 0; i < n; i++) {
            long freq = indexCount.getOrDefault(nums[i], 0L);
            long sum = indexSum.getOrDefault(nums[i], 0L);

            arr[i] += freq * i - sum;

            indexCount.put(nums[i], freq + 1);
            indexSum.put(nums[i], sum + i);
        }

        indexSum.clear();
        indexCount.clear();

        // Right to Left
        for (int i = n - 1; i >= 0; i--) {
            long freq = indexCount.getOrDefault(nums[i], 0L);
            long sum = indexSum.getOrDefault(nums[i], 0L);

            arr[i] += sum - freq * i;

            indexCount.put(nums[i], freq + 1);
            indexSum.put(nums[i], sum + i);
        }

        return arr;
    }
}