class Solution:
    def helper(self, root):
        if root.left is None:
            return root.right
        if root.right is None:
            return root.left
        left = root.left
        right = root.right

        # Find the rightmost node in the left subtree
        temp = left
        while temp.right:
            temp = temp.right
        temp.right = right  # Attach right subtree to rightmost node of left
        return left

    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root:
            return None
        if root.val == key:
            return self.helper(root)

        curr = root
        while root:
            if key < root.val:
                if root.left and root.left.val == key:
                    root.left = self.helper(root.left)
                    break
                root = root.left
            else:
                if root.right and root.right.val == key:
                    root.right = self.helper(root.right)
                    break
                root = root.right
        return curr  # Move return outside the loop
