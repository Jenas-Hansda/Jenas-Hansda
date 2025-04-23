from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val: int = 0, left: Optional['TreeNode'] = None, right: Optional['TreeNode'] = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        self.path = 0

        def dfs(r, left, curr):
            if r is None:
                return
            self.path = max(self.path, curr)
            if left:
                dfs(r.right, False, curr + 1)
                dfs(r.left, True, 1)
            else:
                dfs(r.left, True, curr + 1)
                dfs(r.right, False, 1)

        dfs(root.left, True, 1)
        dfs(root.right, False, 1)

        return self.path
