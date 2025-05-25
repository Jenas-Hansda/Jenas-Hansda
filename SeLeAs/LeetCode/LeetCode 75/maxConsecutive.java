class maxConsecutive {
    public int longestOnes(int[] nums, int k) {
            int zeroCount = 0;
            int start = 0;
            int maxLength = 0;
    
            // Traverse the array with the `end` pointer
            for (int end = 0; end < nums.length; end++) {
                // If the current element is 0, increment the zeroCount
                if (nums[end] == 0)
                    zeroCount++;
    
                // If the number of zeros exceeds `k`, shrink the window from the left
                while (zeroCount > k) {
                    if (nums[start] == 0)
                        zeroCount--;
                    start++;
                }
    
                // Update the maxLength of valid subarrays
                maxLength = Math.max(maxLength, end - start + 1);
            }
        return maxLength;
     }
    
    
}