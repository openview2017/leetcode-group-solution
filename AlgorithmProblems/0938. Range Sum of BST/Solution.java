class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] res = new int[1];
        helper(root, low, high, res);
        return res[0];
    }
    
    private void helper(TreeNode root, int low, int high, int[] res) {
        if (root == null) {
            return;
        }

        if (root.val <= high && root.val >= low) {
            res[0] += root.val;
        }
        
        if (root.val >= low) {
            helper(root.left, low, high, res);
        }
        
        if (root.val <= high) {
            helper(root.right, low, high, res);
        }
        
    }
}