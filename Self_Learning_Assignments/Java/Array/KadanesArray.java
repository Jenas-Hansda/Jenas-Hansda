package Array;

import java.util.Scanner;

public class KadanesArray {
    public static void Kadanes(int numbers[]) {
        // ✅ Handles both positive and all-negative arrays
        int maxSum = numbers[0];
        int currSum = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            currSum = Math.max(numbers[i], currSum + numbers[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        System.out.println("Maximum subarray sum = " + maxSum);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in array: ");
        int n = sc.nextInt();
        int numbers[] = new int[n];

        // Example input hint for the user
        System.out.println("Enter " + n + " elements (e.g., 1 2 -3 4 -2 6):");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        Kadanes(numbers);

        sc.close();
    }
}
