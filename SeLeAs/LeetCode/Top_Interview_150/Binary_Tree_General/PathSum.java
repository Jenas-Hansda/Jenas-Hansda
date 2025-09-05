import util.TreeNode;
import java.util.Deque;
import java.util.ArrayDeque;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // Use Deque instead of Stack for better performance and modern practice
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> sumStack = new ArrayDeque<>();

        nodeStack.push(root);
        sumStack.push(root.val);

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            int currentSum = sumStack.pop();

            // Check if it's a leaf node and sum matches
            if (currentNode.left == null && currentNode.right == null && currentSum == targetSum) {
                return true;
            }

            // Push right child and updated sum
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
                sumStack.push(currentSum + currentNode.right.val);
            }

            // Push left child and updated sum
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
                sumStack.push(currentSum + currentNode.left.val);
            }
        }

        return false;
    }
}
