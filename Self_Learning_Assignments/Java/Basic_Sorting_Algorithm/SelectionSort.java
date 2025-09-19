import java.util.Scanner;

public class SelectionSort {
    

public class SelectionSortExample {

    // Function to perform Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // One by one move the boundary of the unsorted part
        for (int i = 0; i < n - 1; i++) {
            // Assume the current index has the minimum value
            int minIndex = i;

            // Find the minimum element in the remaining unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;  // Update the index of the minimum element
                }
            }

            // Swap the found minimum element with the element at index i
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Main method: reads input, sorts the array, and prints the result
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for the number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Create an array of size n
        int[] arr = new int[n];

        // Ask user to input the array elements
        System.out.println("Enter " + n + " integers(e.g., 1 2 -3 4 -2 6):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Call the selectionSort function
        selectionSort(arr);

        // Print the sorted array
        System.out.println("Sorted array in ascending order:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}

}
