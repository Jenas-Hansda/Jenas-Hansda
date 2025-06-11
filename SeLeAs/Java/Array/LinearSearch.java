package Array;
import java.util.Scanner;

public class LinearSearch {

    // Function to perform linear search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return index if target is found
            }
        }
        return -1; // Return -1 if not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter array elements
        System.out.println("Enter array elements separated by space (e.g., 5 8 3 1 9):");
        String[] input = scanner.nextLine().split(" ");

        // Convert input to an integer array
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Ask for the element to search
        System.out.print("Enter the number to search for: ");
        int target = scanner.nextInt();

        // Perform linear search
        int result = linearSearch(arr, target);

        // Display result
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }

        // Close the scanner
        scanner.close();
    }
}
