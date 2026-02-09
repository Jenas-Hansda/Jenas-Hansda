// Simple approach using inorder tree traversal
// T.C : O(n)
// S.C : O(n)

class BalanceaBinarySearchTree {

    // Inorder traversal to store values in sorted order
    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    // Construct balanced BST from sorted list
    private TreeNode construct(int l, int r, List<Integer> list) {
        if (l > r) return null;

        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(list.get(mid));

        root.left = construct(l, mid - 1, list);
        root.right = construct(mid + 1, r, list);

        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        return construct(0, list.size() - 1, list);
    }
}
