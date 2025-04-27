struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    TreeNode* searchBST(TreeNode* root, int val) {
        if (!root) return nullptr;
        if (val < root->val) {
            return searchBST(root->left, val);
        } else if (val > root->val) {
            return searchBST(root->right, val); 
        } else {
            return root;
        }
    }
};
