package Array;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    // Function to perform binary search
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            // Avoiding integer overflow
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter sorted array elements
        System.out.println("Enter sorted array elements separated by space (e.g., 2 4 6 8 10):");
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];

        // Converting string input to integer array
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Optional: Sort the array in case input is not sorted
        Arrays.sort(arr);

        // Prompt the user to enter the target value to search
        System.out.print("Enter the number to search for: ");
        int target = scanner.nextInt();

        // Perform binary search
        int result = binarySearch(arr, target);

        // Output the result
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }

        scanner.close();
    }
}
