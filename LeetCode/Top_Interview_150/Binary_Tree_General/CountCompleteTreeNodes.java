import util.TreeNode;

public class CountCompleteTreeNodes {

  public int countNodes(TreeNode root) {
    if (root == null) return 0;

    int leftDepth = getLeftDepth(root);
    int rightDepth = getRightDepth(root);

    if (leftDepth == rightDepth) {
      // Tree is a perfect binary tree
      return (1 << leftDepth) - 1;
    } else {
      // Tree is not perfect, recurse on subtrees
      return 1 + countNodes(root.left) + countNodes(root.right);
    }
  }

  private int getLeftDepth(TreeNode node) {
    int depth = 0;
    while (node != null) {
      node = node.left;
      depth++;
    }
    return depth;
  }

  private int getRightDepth(TreeNode node) {
    int depth = 0;
    while (node != null) {
      node = node.right;
      depth++;
    }
    return depth;
  }
}
