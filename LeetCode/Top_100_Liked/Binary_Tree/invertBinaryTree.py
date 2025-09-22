from typing import Optional

from minimumDepthBinaryTree import TreeNode

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
      
        if root is None:
            return
        root.right, root.left = self.invertTree(root.left), self.invertTree(root.right)
        return root 