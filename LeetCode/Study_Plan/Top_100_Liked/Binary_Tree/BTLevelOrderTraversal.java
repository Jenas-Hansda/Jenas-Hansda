import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {
    class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // enqueue root

        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // number of nodes at the current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();  // dequeue
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);  // enqueue left child
                }
                if (node.right != null) {
                    queue.offer(node.right);  // enqueue right child
                }
            }

            result.add(level);  // add current level to result
        }

        return result;
    }
}
}
