class Solution {
    public int kthSmallest(TreeNode root, int k) {
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
        
        return -1; 
    }
}