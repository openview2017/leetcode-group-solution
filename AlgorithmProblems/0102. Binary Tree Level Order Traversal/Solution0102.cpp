#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;


class Solution0102 {

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(!root) return {};
        vector<vector<int>> ans;
        vector<TreeNode*> curr,next;
        curr.push_back(root);
        while(!curr.empty()) {
            ans.push_back({});
            for(TreeNode* node : curr) {
                ans.back().push_back(node->val);
                if(node->left) next.push_back(node->left);
                if(node->right) next.push_back(node->right);
            }
            curr.swap(next);
            next.clear();
        }
        return ans;
    }

public:
    vector<vector<int>> levelOrder0(TreeNode* root) {
        vector<vector<int>> ans;
        DFS(root, 0 /* depth */, ans);
        return ans;
    }
private:
    void DFS(TreeNode* root, int depth, vector<vector<int>>& ans) {
        if(!root) return;
        // Works with pre/in/post order
        while(ans.size()<=depth) ans.push_back({});
        ans[depth].push_back(root->val); // pre-order
        DFS(root->left, depth+1, ans);        
        DFS(root->right, depth+1, ans);   
    }
};