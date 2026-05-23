class Solution {

    /**
     * Finds the index of the minimum element (pivot)
     */
    private int findPivot(int[] nums, int left, int right) {

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Pivot is in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Pivot is at mid or in left half
                right = mid;
            }
        }

        return right;
    }

    /**
     * Standard Binary Search
     */
    private int binarySearch(int[] nums, int left, int right, int target) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {

        int n = nums.length;

        if (n == 0) {
            return -1;
        }

        int pivot = findPivot(nums, 0, n - 1);

        // Target is the minimum element
        if (nums[pivot] == target) {
            return pivot;
        }

        // Array not rotated
        if (pivot == 0) {
            return binarySearch(nums, 0, n - 1, target);
        }

        // Decide correct half
        if (target >= nums[0]) {
            return binarySearch(nums, 0, pivot - 1, target);
        }

        return binarySearch(nums, pivot, n - 1, target);
    }
}