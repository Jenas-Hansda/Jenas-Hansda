import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    private Map<Integer, Integer> levelSums = new HashMap<>();

    private void helper(TreeNode root, int level) {
        if (root != null) {
            levelSums.put(level, levelSums.getOrDefault(level, 0) + root.val);
            helper(root.left, level + 1);
            helper(root.right, level + 1);
        }
    }

    public int maxLevelSum(TreeNode root) {
        helper(root, 1);

        int maxLevel = 1;
        int maxSum = levelSums.get(1);

        for (Map.Entry<Integer, Integer> entry : levelSums.entrySet()) {
            if (entry.getValue() > maxSum || 
                (entry.getValue() == maxSum && entry.getKey() < maxLevel)) {
                maxSum = entry.getValue();
                maxLevel = entry.getKey();
            }
        }

        return maxLevel;
    }
}
