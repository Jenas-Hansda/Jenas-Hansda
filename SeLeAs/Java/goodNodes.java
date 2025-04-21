class goodNodes {
    public int GoodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxVal) {
        if (node == null) return 0;

        int good = 0;
        if (node.val >= maxVal) {
            good = 1;
        }

        maxVal = Math.max(maxVal, node.val);
        good += dfs(node.left, maxVal);
        good += dfs(node.right, maxVal);

        return good;
    }
}
