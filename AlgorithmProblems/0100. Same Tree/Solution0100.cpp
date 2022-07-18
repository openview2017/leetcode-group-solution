

class Solution100 {

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        // Both are emtry: same
        if (!p && !q) return true;
        // One is emtry: not the Same
        if (!p || !q) return false;
        // Both are not emptry, compare the root value
        if (p->val != q->val) return false;
        // Compare left-subtree and right-subtree recursively.
        return isSameTree(p->left, q->left) 
            && isSameTree(p->right, q->right); 
    }
};