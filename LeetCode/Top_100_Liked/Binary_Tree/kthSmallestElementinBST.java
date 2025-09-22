public class kthSmallestElementinBST {
    // Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    // Iterative approach
    public int kthSmallestIterative(TreeNode root, int k) {
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
        
        return -1; // This line should not be reached if k is valid
    }

    // Recursive approach
    private int count = 0;
    private int result = -1;

    public int kthSmallestRecursive(TreeNode root, int k) {
        count = k;
        result = -1;
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode node) {
        if (node == null || result != -1) {
            return;
        }
        
        inOrder(node.left);
        count--;
        if (count == 0) {
            result = node.val;
            return;
        }
        inOrder(node.right);
    }
}

}
