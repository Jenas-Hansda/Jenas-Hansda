package Array;

import java.util.Scanner;

public class PrefixArray {
    public static void SubArray(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        // Calculate prefix array safely
        prefix[0] = numbers[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        // Find max subarray sum using prefix sums
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

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

        // 👇 Add helpful input example
        System.out.println("Enter " + n + " elements (e.g., 1 2 -3 4 -2 6):");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        SubArray(numbers);

        sc.close();
    }
}
