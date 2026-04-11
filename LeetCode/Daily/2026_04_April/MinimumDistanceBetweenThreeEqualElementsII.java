import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> mp = new HashMap<>();
        int result = Integer.MAX_VALUE;

        for (int k = 0; k < n; k++) {
            mp.putIfAbsent(nums[k], new ArrayList<>());
            mp.get(nums[k]).add(k);

            if (mp.get(nums[k]).size() >= 3) {
                List<Integer> vec = mp.get(nums[k]);
                int size = vec.size();

                int i = vec.get(size - 3);
                result = Math.min(result, k - i);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : 2 * result;
    }
}