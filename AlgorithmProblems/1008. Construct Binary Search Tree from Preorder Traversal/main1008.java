public class main1008 {
    
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution1008 { // 35 - 40
    int[] preorder;
    int idx;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        this.idx = 0;
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int min, int max) {
        if (idx >= preorder.length || preorder[idx] < min || preorder[idx] > max) {
            return null;
        }
        int curVal = preorder[idx++];
        TreeNode root = new TreeNode(curVal);
        root.left = helper(min, curVal);
        root.right = helper(curVal, max);
        return root;
    }
}