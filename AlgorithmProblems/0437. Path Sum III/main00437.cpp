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
  int pathSum(TreeNode* root, int sum) {
    ans_ = 0;
    sums_ = {{0, 1}};
    pathSum(root, 0, sum);
    return ans_;
  }
private:
  int ans_;
  unordered_map<int, int> sums_;
  
  void pathSum(TreeNode* root, long cur, int sum) { // !!!long cur
    if (!root) return;
    cur += root->val;
    ans_ += sums_[cur - sum];
    ++sums_[cur];
    pathSum(root->left, cur, sum);
    pathSum(root->right, cur, sum);
    --sums_[cur];
  }
};