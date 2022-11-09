/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    // passed in the root to a binary tree, recursively flatten the levels of the tree
    // then back track splice the left between the root and the right.
    void flatten(TreeNode* root) {
        if (root == nullptr) return;
        flatten(root->left);
        flatten(root->right);
        TreeNode* oldright = root->right;
        root->right = root->left;
        root->left = nullptr;
        TreeNode* walker = root;
        while (walker->right != nullptr) {
          walker = walker->right;
        }
        walker->right = oldright;
    }
};
