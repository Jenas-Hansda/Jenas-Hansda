class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] { root.left, root.right });

        while (!stack.isEmpty()) {
            TreeNode[] pair = stack.pop();
            TreeNode left = pair[0];
            TreeNode right = pair[1];

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            stack.push(new TreeNode[] { left.left, right.right });
            stack.push(new TreeNode[] { left.right, right.left });
        }

        return true;
    }
}