

class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;

        // Step 1: Find the first decreasing element from the end
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }

        // Step 2: If such an element was found, find successor and swap
        if (i > 0) {
            int successorIdx = n - 1;
            while (successorIdx >= i && nums[successorIdx] <= nums[i - 1]) {
                successorIdx--;
            }
            swap(nums, i - 1, successorIdx);
        }

        // Step 3: Reverse the suffix starting at index i
        reverse(nums, i, n - 1);
    }

    // Helper method to swap elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper method to reverse a portion of the array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
