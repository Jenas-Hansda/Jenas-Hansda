import java.util.Scanner;

public class BubbleSortD {

    // Function to perform Bubble Sort in descending order
    public static void bubbleSortDescending(int[] arr) {
        int n = arr.length;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if left element is smaller than right (for descending order)
                if (arr[j] < arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter array elements
        System.out.println("Enter array elements separated by space (e.g., 3 6 2 1 8 7 4 5 3 1):");
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];

        // Convert input strings to integers
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Sort the array in descending order using bubble sort
        bubbleSortDescending(arr);

        // Display the sorted array
        System.out.println("\nArray after Bubble Sort in Descending Order:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
