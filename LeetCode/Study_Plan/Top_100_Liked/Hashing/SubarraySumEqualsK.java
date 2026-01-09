import java.util.HashMap;

public class SubarraySumEqualsK {
public class Solution {
    public int subarraySum(int[] nums, int k) {
        // HashMap to store prefix sums and their frequencies
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1); // handles the case when prefixSum == k

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;

            // Check if (prefixSum - k) exists in the map
            count += prefixSums.getOrDefault(prefixSum - k, 0);

            // Update the count of prefixSum in the map
            prefixSums.put(prefixSum, prefixSums.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
}