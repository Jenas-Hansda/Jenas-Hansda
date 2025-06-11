import java.util.Scanner;

public class InsertionSort {
    

public class InsertionSortExample {

    // Function to perform Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Start from the second element (index 1)
        for (int i = 1; i < n; i++) {
            int key = arr[i];  // Element to be inserted
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert the key at the correct location
            arr[j + 1] = key;
        }
    }

    // Main method: gets input, sorts array, and prints it
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Create array of size n
        int[] arr = new int[n];

        // Ask user to input array elements
        System.out.println("Enter " + n + " integers(e.g., 1 2 -3 4 -2 6):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Call the insertionSort function
        insertionSort(arr);

        // Print the sorted array
        System.out.println("Sorted array in ascending order:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}

}
