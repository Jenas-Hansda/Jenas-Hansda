package Array_String;

public class RemoveElement {
    class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;  // Pointer for the next position of non-val elements

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;  // New length of the array without `val`
    }
}

}
