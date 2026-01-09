import util.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> avgList = new ArrayList<>();
    if (root == null) return avgList;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      double sum = 0;

      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        sum += node.val;

        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }

      avgList.add(sum / levelSize);
    }

    return avgList;
  }
}
