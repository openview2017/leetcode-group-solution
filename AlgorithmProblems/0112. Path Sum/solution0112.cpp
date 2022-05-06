class Solution0112 {
public:
  bool hasPathSum(TreeNode* root, int sum) {
    if (!root) return false;
    if (!root->left && !root->right) return root->val==sum;
    int new_sum = sum - root->val;
    return hasPathSum(root->left, new_sum) || hasPathSum(root->right, new_sum);
  }
};