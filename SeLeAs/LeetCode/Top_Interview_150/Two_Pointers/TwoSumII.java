package Top_Interview_150.Two_Pointers;

public class TwoSumII {
    

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int beg = 0, end = numbers.length - 1;

        while (beg < end) {
            int total = numbers[beg] + numbers[end];

            if (total == target) {
                // Return 1-based indices
                return new int[] { beg + 1, end + 1 };
            } else if (total > target) {
                end--;
            } else {
                beg++;
            }
        }

        // If no solution is found — though problem guarantees one
        return new int[0];
    }
}

}
