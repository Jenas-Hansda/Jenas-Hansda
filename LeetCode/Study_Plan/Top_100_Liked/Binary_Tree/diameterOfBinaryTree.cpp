class Solution {
public:
    int ans = 0;

    int height(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }

        int leftht = height(root->left);
        int rightht = height(root->right);

        ans = max(ans, leftht + rightht); 
        return max(leftht, rightht) + 1;
    }

    int diameterOfBinaryTree(TreeNode* root) {
        height(root);
        return ans;
    }
};
