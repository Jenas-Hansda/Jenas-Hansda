import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefrom {  


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build hashmap for quick lookup of index positions in inorder array
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // Start recursive construction
        return buildSubTree(preorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int[] preorder, int preL, int inL, int inR) {
        if (inL > inR) return null;

        // Root node is at index preL in preorder
        TreeNode root = new TreeNode(preorder[preL]);

        // Get the index of the root from inorder array
        int inorderRootIndex = inorderIndexMap.get(root.val);

        // Calculate size of left subtree
        int leftSubtreeSize = inorderRootIndex - inL;

        // Recursively build left and right subtrees
        root.left = buildSubTree(preorder, preL + 1, inL, inorderRootIndex - 1);
        root.right = buildSubTree(preorder, preL + 1 + leftSubtreeSize, inorderRootIndex + 1, inR);

        return root;
    }
}

}