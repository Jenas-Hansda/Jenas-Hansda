import java.util.*;

public class CountingSort {

    public class CountingSortExample {

        // Function to perform Counting Sort
        public static void countingSort(int[] arr) {
            int n = arr.length;

            // Step 1: Find the maximum element in the array
            int max = arr[0];
            for (int i = 1; i < n; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }

            // Step 2: Create a count array of size max + 1
            int[] count = new int[max + 1];

            // Step 3: Store the count of each element
            for (int i = 0; i < n; i++) {
                count[arr[i]]++;
            }

            // Step 4: Build the sorted array using the count array
            int index = 0;
            for (int i = 0; i <= max; i++) {
                while (count[i] > 0) {
                    arr[index++] = i;
                    count[i]--;
                }
            }
        }

        // Main method: gets user input, sorts the array, and prints it
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Ask user for the number of elements
            System.out.print("Enter the number of elements: ");
            int n = scanner.nextInt();

            // Create array and read input
            int[] arr = new int[n];
            System.out.println("Enter " + n + " non-negative integers:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();

                // Check for negative input (Counting Sort requires non-negative integers)
                if (arr[i] < 0) {
                    System.out.println("Error: Counting Sort only works with non-negative integers.");
                    return;
                }
            }

            // Call the sorting function
            countingSort(arr);

            // Print the sorted array
            System.out.println("Sorted array in ascending order:");
            for (int num : arr) {
                System.out.print(num + " ");
            }

            scanner.close();
        }
    }

}
