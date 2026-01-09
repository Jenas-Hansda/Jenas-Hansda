class Solution {
    private Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildSubTree(preorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int[] preorder, int preL, int inL, int inR) {
        if (inL > inR) return null;

        TreeNode root = new TreeNode(preorder[preL]);

        int inorderRootIndex = inorderIndexMap.get(root.val);

        int leftSubtreeSize = inorderRootIndex - inL;

        root.left = buildSubTree(preorder, preL + 1, inL, inorderRootIndex - 1);
        root.right = buildSubTree(preorder, preL + 1 + leftSubtreeSize, inorderRootIndex + 1, inR);

        return root;
    }
}
