class longestSubarray {
    public int LongestSubarray(int[] nums) {
        int maxLen = 0;
        int start = 0;
        int zeroCount = 0;

        // Iterate through the array with the 'end' pointer
        for (int end = 0; end < nums.length; end++) {
            // If we encounter a 0, increment the zero count
            if (nums[end] == 0) {
                zeroCount++;
            }

            // If there are more than one zero in the window, shrink the window from the left
            while (zeroCount > 1) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }

            // Update the maximum length of the valid window (subtracting 1 because we remove one zero)
            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }
}
