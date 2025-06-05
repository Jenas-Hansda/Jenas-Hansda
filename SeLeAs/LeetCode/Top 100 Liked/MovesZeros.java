public class MovesZeros{
    class Solution {
    public void moveZeroes(int[] nums) {
        int insert = 0;
        
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] != 0) {
                
                if (insert != i) {
                    int temp = nums[insert];
                    nums[insert] = nums[i];
                    nums[i] = temp;
                }
                
                insert++;
            }
        }
    }
}
}