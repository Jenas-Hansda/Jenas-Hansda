

public class MaximumProductSubarray{
    class Solution {
    public int maxProduct(int[] nums) {
        int minProduct = nums[0];
        int maxProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            int prevMin = minProduct;
            int prevMax = maxProduct;

            minProduct = Math.min(num, Math.min(num * prevMin, num * prevMax));
            maxProduct = Math.max(num, Math.max(num * prevMin, num * prevMax));

            result = Math.max(result, maxProduct);
        }

        return result;
    }
}

}