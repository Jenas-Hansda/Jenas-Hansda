import java.util.HashMap;


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
    private HashMap<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        inorderIndexMap = new HashMap<>();
        
        // Build the index map for inorder traversal
        for (int i = 0; i < n; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildBT(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildBT(int[] inorder, int[] postorder,
                             int inStart, int inEnd,
                             int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inorderIndexMap.get(rootVal);
        int leftSize = rootIndex - inStart;

        root.left = buildBT(inorder, postorder,
                            inStart, rootIndex - 1,
                            postStart, postStart + leftSize - 1);

        root.right = buildBT(inorder, postorder,
                             rootIndex + 1, inEnd,
                             postStart + leftSize, postEnd - 1);

        return root;
    }
}
