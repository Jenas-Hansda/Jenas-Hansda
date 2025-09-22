public class findPivot {
    class Solution {
        public int pivotIndex(int[] nums) {
            int leftSum = 0;
            int rightSum = 0;
            
            // Calculate the total sum of the array
            for (int num : nums) {
                rightSum += num;
            }
            
            for (int i = 0; i < nums.length; i++) {
                rightSum -= nums[i];  // Subtract the current element from the right sum
                
                if (leftSum == rightSum) {
                    return i;  // Return the index if the left sum equals right sum
                }
                
                leftSum += nums[i];  // Add the current element to the left sum
            }
            
            return -1;  // Return -1 if no pivot index is found
        }
    }
    
}
