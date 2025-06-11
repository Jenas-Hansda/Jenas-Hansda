    import java.util.Scanner;

public class SelectionSortD {
    // Function to perform Selection Sort in descending order
    public static void selectionSortDescending(int[] arr) {
        int n = arr.length;

        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            // Find the index of the maximum element in the unsorted part
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap the found maximum element with the first element of unsorted part
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.println("Enter array elements separated by space (e.g., 3 6 2 1 8 7 4 5 3 1):");
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];

        // Convert input strings to integers
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Sort array in descending order
        selectionSortDescending(arr);

        // Print the sorted array
        System.out.println("\nArray after Selection Sort in Descending Order:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}