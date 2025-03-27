public class moveZeroes {
    public void MoveZeroes(int[] nums) {
        // Pointer to track where the next non-zero element should go
        int insert = 0;
        
        // Loop through all elements in the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is non-zero
            if (nums[i] != 0) {
                // Only swap if insert != i (to avoid unnecessary swapping)
                if (insert != i) {
                    int temp = nums[insert];
                    nums[insert] = nums[i];
                    nums[i] = temp;
                }
                // Increment the insert pointer
                insert++;
            }
        }
    }
}