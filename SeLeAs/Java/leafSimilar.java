import java.util.*;

class TreeNode {
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        
        getLeaf(root1, leaf1);
        getLeaf(root2, leaf2);
        
        return leaf1.equals(leaf2);
    }

    private void getLeaf(TreeNode root, List<Integer> result) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }

        if (root.left != null) {
            getLeaf(root.left, result);
        }
        if (root.right != null) {
            getLeaf(root.right, result);
        }
    }
}
