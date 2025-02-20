#include <stdio.h>

int main() {
    int n, i;

    // Prompt the user to input the size of the array
    printf("Input the size of the array: ");
    scanf("%d", &n);

    // Declare an array of size n to store integer values
    int arr[n];

    // Prompt the user to input n elements into the array
    printf("Input %d elements (integer type) in the array:\n", n);
    for (i = 0; i < n; i++) {
        printf("element - %d: ", i);
        scanf("%d", &arr[i]); // Read the input and store it in the array
    }

    // Display the elements in the array
    printf("Elements in the array are: ");
    for (i = 0; i < n; i++) {
        printf("%d ", arr[i]); // Print each element in the array
    }
    printf("\n"); // New line for better output formatting

    return 0; // Indicate successful execution of the program
}
