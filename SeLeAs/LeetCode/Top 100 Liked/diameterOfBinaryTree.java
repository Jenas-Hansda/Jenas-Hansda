

public class diameterOfBinaryTree {
    class Solution {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftht = height(root.left);
        int rightht = height(root.right);

        ans = Math.max(ans, leftht + rightht);
        return Math.max(leftht, rightht) + 1;
    }
}

}