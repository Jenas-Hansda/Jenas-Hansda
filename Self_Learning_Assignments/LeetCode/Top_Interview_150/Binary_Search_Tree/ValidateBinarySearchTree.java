class Solution {
    
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long lower, long upper) {
        if (node == null) return true;

        if (node.val <= lower || node.val >= upper) return false;

        return helper(node.left, lower, node.val) &&
               helper(node.right, node.val, upper);
    }
}