class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int beg = 0, end = nums.length - 1;
        while (beg < end) {
            int mid = (beg + end) / 2;
            if (nums[mid] > nums[end]) {
                beg = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[end];
    }
}