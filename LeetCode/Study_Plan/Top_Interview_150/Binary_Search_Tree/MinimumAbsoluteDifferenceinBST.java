class MinimumAbsoluteDifferenceinBST {
    
    private Integer minDiff = Integer.MAX_VALUE;
    private TreeNode prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }
    
    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        
        inOrder(root.left);
        
        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev.val);
        }
        
        prev = root;
        
        inOrder(root.right);
    }
}
