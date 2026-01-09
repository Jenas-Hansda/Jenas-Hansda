class MaximumProductofSplittedBinaryTree {

    private static final long MOD = 1_000_000_007;
    private long totalSum = 0;
    private long maxProduct = 0;

    private long findTotalSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        long leftSum = findTotalSum(root.left);
        long rightSum = findTotalSum(root.right);

        long subtreeSum = root.val + leftSum + rightSum;

        // Update max product using current subtree
        maxProduct = Math.max(maxProduct, subtreeSum * (totalSum - subtreeSum));

        return subtreeSum;
    }

    public int maxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // First pass: calculate total sum of tree
        totalSum = findTotalSum(root);

        // Reset maxProduct before second pass
        maxProduct = 0;

        // Second pass: calculate maximum product
        findTotalSum(root);

        return (int) (maxProduct % MOD);
    }
}
