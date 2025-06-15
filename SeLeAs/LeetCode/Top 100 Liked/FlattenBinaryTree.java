

public class FlattenBinaryTree {

    // Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

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
            // Attach the right subtree to the end of the flattened left subtree
            if (leftTail != null) {
                leftTail.right = node.right;
            }
            // Move the left subtree to the right
            node.right = node.left;
            node.left = null;
        }

        // Return the last node in the flattened tree
        return rightTail != null ? rightTail : (leftTail != null ? leftTail : node);
    }
}

}