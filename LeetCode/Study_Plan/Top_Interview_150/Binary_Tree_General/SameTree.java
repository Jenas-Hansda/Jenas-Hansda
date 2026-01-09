import util.TreeNode; // Importing TreeNode class from util package
import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

  // Method to check if two binary trees are structurally identical and have the same node values
  public boolean isSameTree(TreeNode root1, TreeNode root2) {
    // Initialize a queue to perform breadth-first traversal of both trees simultaneously
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root1); // Add root of first tree
    queue.add(root2); // Add root of second tree

    // Continue processing while there are nodes in the queue
    while (!queue.isEmpty()) {
      TreeNode first = queue.poll();  // Get the next node from the first tree
      TreeNode second = queue.poll(); // Get the next node from the second tree

      // If both nodes are null, continue to the next pair (no mismatch here)
      if (first == null && second == null) {
        continue;
      }
      // If one is null or values are not equal, trees are not the same
      else if (
          first == null || second == null || first.val != second.val) {
        return false;
      }

      // Enqueue the left children of both nodes
      queue.add(first.left);
      queue.add(second.left);

      // Enqueue the right children of both nodes
      queue.add(first.right);
      queue.add(second.right);
    }

    // If no mismatches found during traversal, the trees are the same
    return true;
  }
}
