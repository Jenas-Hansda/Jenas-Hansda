class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxSum;
    }

    private int pathSum(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, pathSum(node.left));
        int right = Math.max(0, pathSum(node.right));

        maxSum = Math.max(maxSum, left + right + node.val);

        return Math.max(left, right) + node.val;
    }
}