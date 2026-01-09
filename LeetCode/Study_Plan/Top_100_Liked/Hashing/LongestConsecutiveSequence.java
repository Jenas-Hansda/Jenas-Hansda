import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLen = 0;

        for (int num : numSet) {
            // Only start counting if it's the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int current = num;
                int length = 1;

                while (numSet.contains(current + 1)) {
                    current++;
                    length++;
                }

                maxLen = Math.max(maxLen, length);
            }
        }

        return maxLen;
    }
}

}
