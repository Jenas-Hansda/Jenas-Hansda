

public class JumpGame {
    class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;                    // The farthest index we can reach
        int lastIndex = nums.length - 1;     // The goal index

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;                // If we can't reach index i
            }
            if (i + nums[i] > maxReach) {
                maxReach = i + nums[i];      // Update the farthest reachable index
            }
            if (maxReach >= lastIndex) {
                return true;                 // If we can reach or go past the last index
            }
        }

        return false; // In case we finish loop without reaching the end
    }
}

}