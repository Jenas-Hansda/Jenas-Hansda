package Array_String;

public class RemoveDuplicatesfromSortedArrayII {
    class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int e : nums) {
            if (i < 2 || nums[i - 2] != e) {
                nums[i] = e;
                i++;
            }
        }
        return i;
    }
}

}
