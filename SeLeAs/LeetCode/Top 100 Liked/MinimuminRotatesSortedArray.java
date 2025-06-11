public class MinimuminRotatesSortedArray {
    public class Solution {

    // Recursive Solution to find the minimum in a rotated sorted array
    public int findMinRecursive(int[] nums) {
        return find(0, nums.length - 1, nums);
    }

    /**
     * Helper method for recursive binary search
     * @param beg Start index of the search interval
     * @param end End index of the search interval
     * @param nums Input array (rotated sorted array)
     * @return The minimum value in the array
     */
    private int find(int beg, int end, int[] nums) {
        // Base case: if the search space is reduced to a single element
        if (end <= beg) {
            return nums[end];
        }

        int mid = (beg + end) / 2;

        // If middle element is greater than the end element,
        // then the minimum must be in the right half
        if (nums[mid] > nums[end]) {
            return find(mid + 1, end, nums);
        } else {
            // Otherwise, the minimum is in the left half including mid
            return find(beg, mid, nums);
        }
    }

    // Iterative Solution to find the minimum in a rotated sorted array
    public int findMin(int[] nums) {
        int beg = 0, end = nums.length - 1;

        // Binary search loop
        while (beg < end) {
            int mid = (beg + end) / 2;

            // If mid element is greater than end element,
            // the minimum is in the right half
            if (nums[mid] > nums[end]) {
                beg = mid + 1;
            } else {
                // Otherwise, it's in the left half including mid
                end = mid;
            }
        }

        // After the loop, beg == end and points to the minimum element
        return nums[end];
    }
}


}
