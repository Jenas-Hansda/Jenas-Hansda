package Array_String;

public class RemoveDuplicatesfromSortedArray {
    public class Solution {
    
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0; // Edge case: empty array

        // Pointer i tracks the position of the last unique element
        int i = 0;

        // Start from the second element and move through the array
        for (int j = 1; j < n; j++) {
            // If current element is different from the last unique element
            if (nums[i] != nums[j]) {
                i++;              // Move to the next position
                nums[i] = nums[j]; // Copy the new unique element
            }
        }

        // The array from index 0 to i now contains the unique elements
        return i + 1;
    }
}

}
