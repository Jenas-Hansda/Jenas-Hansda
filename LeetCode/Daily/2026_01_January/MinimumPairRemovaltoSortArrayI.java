import java.util.*;

class Solution {

    // Find index of adjacent pair with MINIMUM sum
    private int minPairIndex(List<Integer> nums) {
        int minSum = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < nums.size() - 1; i++) {
            int sum = nums.get(i) + nums.get(i + 1);
            if (sum < minSum) {
                minSum = sum;
                index = i;
            }
        }
        return index;
    }

    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);

        int operations = 0;

        while (!isSorted(list)) {
            int index = minPairIndex(list);

            // Merge pair
            list.set(index, list.get(index) + list.get(index + 1));
            list.remove(index + 1);

            operations++;
        }

        return operations;
    }

    private boolean isSorted(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
