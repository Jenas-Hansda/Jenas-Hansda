class SortColors {


  public void sortColors(int[] nums) {
    if (nums == null || nums.length == 0) {
      return; // No need to sort if the array is null or empty
    }

    int start = 0;         // Points to the next position to place 0
    int mid = 0;           // Current element under consideration
    int end = nums.length - 1; // Points to the next position to place 2

    // Process elements until mid surpasses end
    while (mid <= end) {
      switch (nums[mid]) {
        case 0:
          // Swap current 0 to the start position and move both pointers forward
          swap(nums, start, mid);
          start++;
          mid++;
          break;

        case 1:
          // 1 is already in the correct middle position
          mid++;
          break;

        case 2:
          // Swap current 2 to the end position and move end pointer backward
          swap(nums, mid, end);
          end--;
          // Do not increment mid here because the swapped value needs to be checked
          break;
      }
    }
  }

  // Swaps two elements in the array
  private void swap(int[] arr, int pos1, int pos2) {
    int temp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = temp;
  }
}
