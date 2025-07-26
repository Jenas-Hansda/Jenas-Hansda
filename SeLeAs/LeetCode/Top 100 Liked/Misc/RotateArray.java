

class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;

        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);         // Reverse the whole array
        reverse(nums, 0, k - 1);                   // Reverse first k elements
        reverse(nums, k, nums.length - 1);         // Reverse the rest
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
