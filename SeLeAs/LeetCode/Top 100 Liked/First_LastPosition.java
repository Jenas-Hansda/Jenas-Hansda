public class First_LastPosition {
    class Solution {
    // Main method to find the starting and ending position of a given target in a sorted array
    public int[] searchRange(int[] nums, int target) {
        // Edge case: if the input array is null or empty, return [-1, -1]
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        // Perform binary search to find the first occurrence of the target
        int first = firstSearch(nums, target);
        
        // If the target is not found, return [-1, -1]
        if (first == -1) {
            return new int[]{-1, -1};
        }

        // Perform binary search to find the last occurrence of the target
        // Start from the index of the first occurrence for optimization
        int last = lastSearch(nums, target, first, nums.length - 1);

        // Return the starting and ending indices of the target
        return new int[]{first, last};
    }

    // Helper method to find the first occurrence of the target using binary search
    private int firstSearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        // Continue searching while the search space is valid
        while (l < r) {
            int mid = (l + r) / 2;

            // Move the left boundary if mid is less than target
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                // Otherwise, move the right boundary to narrow down to first occurrence
                r = mid;
            }
        }

        // After the loop, l == r. Check if the value at index l is the target
        return nums[l] == target ? l : -1;
    }

    // Helper method to find the last occurrence of the target using binary search
    private int lastSearch(int[] nums, int target, int l, int r) {
        // Continue searching while the search space is valid
        while (l < r) {
            // Bias the mid toward the right to avoid infinite loop when l + 1 == r
            int mid = (l + r + 1) / 2;

            // If mid value is greater than target, reduce the right boundary
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                // Otherwise, move the left boundary to mid
                l = mid;
            }
        }

        // After the loop, l == r. Check if the value at index l is the target
        return nums[l] == target ? l : -1;
    }
}


}
