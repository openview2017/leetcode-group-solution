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
class Solution0113 {
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> ans;
        vector<int> cur;
        helper(root, targetSum, cur, ans);
        return ans;
    }

private:
    void helper(TreeNode* root, int targetSum, vector<int>& cur, vector<vector<int>>& ans) {
        if (root == nullptr) {return;}
        
        cur.push_back(root->val);
        
        if (root->left == nullptr && root->right == nullptr && root->val == targetSum) {
            //ans.push_back(vector<int>(cur)); // works!!!
            ans.push_back(cur);
            //return;
        }
        
        int newSum = targetSum - root->val;
        helper(root->left, newSum, cur, ans);
        helper(root->right, newSum, cur, ans);
        cur.pop_back();
    }
};