import java.util.Scanner;

public class BubbleSort {
    

public class BubbleSortExample {

    // Function to perform Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for pairwise comparisons
            for (int j = 0; j < n - 1 - i; j++) {
                // Swap if elements are in wrong order
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no two elements were swapped, array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Main method: takes input, sorts array, prints result
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for the number of elements
        System.out.print("Enter the number of elements:- ");
        int n = scanner.nextInt();

        // Create an array of size n
        int[] arr = new int[n];

        // Ask user to enter the array elements
        System.out.println("Enter " + n + " integers (e.g., 1 2 -3 4 -2 6) :-");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Call the bubbleSort function
        bubbleSort(arr);

        // Print the sorted array
        System.out.println("Sorted array in ascending order:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}

}