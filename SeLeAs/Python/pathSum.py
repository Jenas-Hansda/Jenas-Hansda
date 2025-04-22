from collections import defaultdict
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        self.paths = 0
        self.pathSums = defaultdict(int)
        self.pathSums[0] = 1

        def dfs(r, currSum):
            if r is None:
                return
            currSum += r.val
            self.paths += self.pathSums[currSum - targetSum]
            self.pathSums[currSum] += 1
            if r.right:
                dfs(r.right, currSum)
            if r.left:
                dfs(r.left, currSum)

            self.pathSums[currSum] -= 1  # Backtrack

        dfs(root, 0)
        return self.paths
