class Solution {

    private int helper(int num) {
        int sum = 0;

        while (num != 0) {
            sum = sum + num % 10;
            num /= 10;
        }

        return sum;
    }

    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            int digitSum = helper(num);
            min = Math.min(min, digitSum);
        }

        return min;
    }
}