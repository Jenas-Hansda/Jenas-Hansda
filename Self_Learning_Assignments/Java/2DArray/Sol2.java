

public class Sol2 {
    public static void BruteForce(int[][] nums) {
        int sum = 0;

        // Directly sum the second row (index 1)
        for (int j = 0; j < nums[1].length; j++) {
            sum += nums[1][j];
        }

        System.out.println("Sum of 2nd row is: " + sum);
    }

    public static void main(String[] args) {
        int[][] nums = {
            {1, 4, 9},
            {11, 4, 3},
            {2, 2, 3}
        };
        BruteForce(nums);
    }
}
