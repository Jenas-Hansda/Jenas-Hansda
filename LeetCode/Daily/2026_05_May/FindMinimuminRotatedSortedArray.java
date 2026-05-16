class Solution {

    public int findPivot(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {

            int mid = l + (r - l) / 2;

            // Minimum lies on right side
            if (nums[mid] > nums[r]) {

                // discard mid because it cannot be minimum
                l = mid + 1;

            } else {

                // minimum could be at mid
                r = mid;
            }
        }

        return nums[l];
    }

    public int findMin(int[] nums) {
        return findPivot(nums);
    }
}
