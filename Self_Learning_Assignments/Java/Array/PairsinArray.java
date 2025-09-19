package Array;
import java.util.Scanner;
public class PairsinArray {
    // Function to print all unique pairs in the array
    public static void printAllPairs(int[] arr) {
        System.out.println("\nAll unique pairs are:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("(" + arr[i] + ", " + arr[j] + ")");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompting user to enter array elements with example
        System.out.println("Enter array elements separated by space (e.g., 1 2 3 4):");
        String[] input = scanner.nextLine().split(" ");

        // Convert input to integer array
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Call the function to print pairs
        printAllPairs(arr);

        // Close scanner
        scanner.close();
    }
}