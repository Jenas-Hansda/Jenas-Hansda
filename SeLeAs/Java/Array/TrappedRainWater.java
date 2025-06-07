package Array;

import java.util.Scanner;

public class TrappedRainWater {

    // Function to calculate trapped rainwater using two-pointer approach
    public static void trapRainWater(int[] height) {
        int n = height.length;
        if (n == 0) {
            System.out.println("No bars to trap water.");
            return;
        }

        // Initialize two pointers
        int left = 0, right = n - 1;

        // Track the maximum height to the left and right of each bar
        int leftMax = 0, rightMax = 0;

        // Total trapped water
        int trappedWater = 0;

        // Loop until the two pointers meet
        while (left < right) {
            // Process the smaller side
            if (height[left] <= height[right]) {
                // Update leftMax or calculate water
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++; // Move left pointer inward
            } else {
                // Update rightMax or calculate water
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--; // Move right pointer inward
            }
        }

        // Output the result
        System.out.println("Total trapped rainwater = " + trappedWater);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user for number of bars
        System.out.print("Enter number of bars (e.g., 7): ");
        int n = sc.nextInt();
        int[] height = new int[n];

        // Guide user with example input
        System.out.println("Enter " + n + " bar heights (e.g., 4 2 0 6 3 2 5):");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        // Calculate and display trapped water
        trapRainWater(height);

        sc.close();
    }
}
