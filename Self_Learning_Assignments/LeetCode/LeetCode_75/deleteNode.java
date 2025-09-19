
public class deleteNode{
class Solution {
    private TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        // Find the rightmost node in the left subtree
        TreeNode temp = left;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = right;  // Attach right subtree to the rightmost node of left
        return left;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return helper(root);
        }

        TreeNode curr = root;
        while (root != null) {
            if (key < root.val) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                }
                root = root.left;
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                }
                root = root.right;
            }
        }
        return curr;
    }
}
}