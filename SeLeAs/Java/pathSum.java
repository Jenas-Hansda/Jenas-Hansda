import java.util.HashMap;
import java.util.Map;

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
    private int paths = 0;
    private Map<Integer, Integer> pathSums = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        pathSums.put(0, 1);  
        dfs(root, 0, targetSum);
        return paths;
    }

    private void dfs(TreeNode node, int currSum, int targetSum) {
        if (node == null) return;

        currSum += node.val;
        paths += pathSums.getOrDefault(currSum - targetSum, 0);
        pathSums.put(currSum, pathSums.getOrDefault(currSum, 0) + 1);

        dfs(node.left, currSum, targetSum);
        dfs(node.right, currSum, targetSum);

        pathSums.put(currSum, pathSums.get(currSum) - 1);  
    }
}
