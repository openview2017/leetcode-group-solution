// TC:O(n)
// SC:O(height)
class Solution {
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        recover(root);
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }
    
    private void recover(TreeNode root) {
        if (root == null) {
            return;
        }
        recover(root.left);
        if (firstNode == null && root.val < preNode.val) {
            firstNode = preNode;
        }
        if (firstNode != null && root.val < preNode.val) {
            secondNode = root;
        }
        preNode = root;
        recover(root.right);
    }
}