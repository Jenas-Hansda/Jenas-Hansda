

public class PartitionEqualSubsetSum{
    

class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        // If total is odd, partitioning into two equal subsets is not possible
        if (total % 2 != 0) return false;

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // base case: sum 0 is always possible

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}


}