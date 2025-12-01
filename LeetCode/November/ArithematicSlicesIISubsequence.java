import java.util.*;

class ArithematicSlicesIISubsequence {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        long result = 0;
        
        // Array of HashMaps: Each stores diff -> count
        Map<Long, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                
                int countAtJ = dp[j].getOrDefault(diff, 0);
                int countAtI = dp[i].getOrDefault(diff, 0);
                
                dp[i].put(diff, countAtI + countAtJ + 1);
                result += countAtJ;
            }
        }
        
        return (int) result;
    }
}
