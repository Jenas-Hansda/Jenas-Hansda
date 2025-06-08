public class RotatedSortedArray {
    public class Solution {
    public int search(int[] nums, int target) {
        int beg = 0, end = nums.length - 1;

        // Perform binary search within the bounds
        while (beg <= end) {
            int mid = (beg + end) / 2;  // Find the middle index

            // If the mid element is the target, return its index
            if (nums[mid] == target) {
                return mid;
            }

            // Determine which half is sorted

            // Left half is sorted
            if (nums[beg] <= nums[mid]) {
                // Check if the target lies within the sorted left half
                if (nums[beg] <= target && target < nums[mid]) {
                    end = mid - 1;  // Discard the right half
                } else {
                    beg = mid + 1;  // Discard the left half
                }
            }

            // Right half is sorted
            else {
                // Check if the target lies within the sorted right half
                if (nums[mid] < target && target <= nums[end]) {
                    beg = mid + 1;  // Discard the left half
                } else {
                    end = mid - 1;  // Discard the right half
                }
            }
        }

        // Target not found
        return -1;
    }
}


}
