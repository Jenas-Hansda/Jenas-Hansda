package Array;

import java.util.Scanner;

public class SubArray {
    public static void MaxSubArraySum(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                currSum = 0;
                for (int k = start; k <= end; k++) {
                    currSum += numbers[k];
                }
                System.out.println("Subarray (" + start + " to " + end + ") sum = " + currSum);
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max sum = " + maxSum);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in array: ");
        int n = sc.nextInt();
        int numbers[] = new int[n];

        // 👇 Add user guidance
        System.out.println("Enter " + n + " elements (e.g., 1 2 -3 4 -2 6):");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        MaxSubArraySum(numbers);

        sc.close();
    }
}
