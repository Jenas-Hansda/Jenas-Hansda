

public class invertBinaryTree {
    class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null; // Base case: empty tree
        }
        
        // Recursively invert the left and right subtrees
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        // Swap left and right children
        root.left = right;
        root.right = left;
        
        return root;
    }
}

}