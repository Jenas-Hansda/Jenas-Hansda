from typing import Optional

# Define TreeNode class (only needed if not using LeetCode's built-in one)
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        def getLeaf(root, result):
            if root.left is None and root.right is None:
                result.append(root.val)
                return
            if root.left:
                getLeaf(root.left, result)
            if root.right:
                getLeaf(root.right, result)

        leaf1 = []
        leaf2 = []
        getLeaf(root1, leaf1)
        getLeaf(root2, leaf2)
        return leaf1 == leaf2
