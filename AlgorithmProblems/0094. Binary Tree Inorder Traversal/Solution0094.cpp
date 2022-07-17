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

#include <iostream>
#include <string>
#include <vector>
using namespace std;


class Solution0 {
  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };
  
public:
  vector<int> inorderTraversal(TreeNode* root) {    
    vector<int> ans;
    inorderTraversal(root, ans);
    return ans;
  }
private:
  void inorderTraversal(TreeNode* root, vector<int>& ans) {
    if (root == nullptr) return;
    inorderTraversal(root->left, ans);
    ans.push_back(root->val);
    inorderTraversal(root->right, ans);    
  }
};

class Solution {
   struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };

public:
  vector<int> inorderTraversal(TreeNode* root) {
    if (root == nullptr) return {};
    vector<int> ans;
    stack<TreeNode*> s;
    TreeNode* curr = root;
    while (curr != nullptr || !s.empty()) {
      while (curr != nullptr) {
        s.push(curr);
        curr = curr->left;
      }
      curr = s.top(); s.pop();
      ans.push_back(curr->val);
      curr = curr->right;
    }    
    return ans;
  }
};