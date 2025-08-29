class Solution {
    public void flatten(TreeNode root) {
      dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode leftTail = dfs(node.left);
        TreeNode rightTail = dfs(node.right);

        if (node.left != null) {
            if (leftTail != null) {
                leftTail.right = node.right;
            }
            node.right = node.left;
            node.left = null;
        }

        return rightTail != null ? rightTail : (leftTail != null ? leftTail : node);
      
    }
}
