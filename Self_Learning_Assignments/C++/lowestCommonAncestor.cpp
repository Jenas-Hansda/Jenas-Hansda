
#include <iostream>

using namespace std;

// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
    public:
        TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
            if (root == nullptr) return nullptr;
    
            if (root == p || root == q) return root;
    
            TreeNode* leftN = lowestCommonAncestor(root->left, p, q);
            TreeNode* rightN = lowestCommonAncestor(root->right, p, q);
    
            if (leftN != nullptr && rightN != nullptr)
                return root;
    
            return leftN != nullptr ? leftN : rightN;
        }
    };
    