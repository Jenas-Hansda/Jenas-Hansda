class SmallestSubtreewithalltheDeepestNodes {

    private static class Result {
        int depth;
        TreeNode node;

        Result(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(0, null);
        }

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.depth == right.depth) {
            return new Result(left.depth + 1, root);
        } else if (left.depth > right.depth) {
            return new Result(left.depth + 1, left.node);
        } else {
            return new Result(right.depth + 1, right.node);
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }
}
