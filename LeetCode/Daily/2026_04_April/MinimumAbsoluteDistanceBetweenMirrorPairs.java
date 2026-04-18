import java.util.*;

class Solution {

    public int getReverse(int n) {
        int rev = 0;

        while (n > 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n /= 10;
        }

        return rev;
    }

    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> mp = new HashMap<>(); // reversed -> index
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (mp.containsKey(nums[i])) {
                result = Math.min(result, i - mp.get(nums[i]));
            }

            mp.put(getReverse(nums[i]), i);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}