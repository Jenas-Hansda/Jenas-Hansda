import java.util.Arrays;

class MinimizeMaximumPairSuminArray {
    public int minPairSum(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        int maxResult = 0;
        int i = 0, j = nums.length - 1;

        // Two-pointer approach
        while (i < j) {
            int sum = nums[i] + nums[j];
            maxResult = Math.max(maxResult, sum);
            i++;
            j--;
        }

        return maxResult;
    }
}
