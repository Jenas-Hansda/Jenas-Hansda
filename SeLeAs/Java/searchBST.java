public class searchBST{// Define the TreeNode class
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor for TreeNode
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // Base case: if the root is null, return null
        if (root == null) {
            return null;
        }

        // If the value is less than the root's value, search in the left subtree
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        // If the value is greater than the root's value, search in the right subtree
        else if (val > root.val) {
            return searchBST(root.right, val);
        }
        // If the value is equal to the root's value, return the root
        else {
            return root;
        }
    }
}
}