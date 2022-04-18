/*
similar to 1522 Diameter of N-ary Tree
also similar to 124. Binary Tree Maximum Path Sum

*/
class Solution {
    
    // return the longest length through the root
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] diameter = new int[1];
        helper(root, diameter);
        return diameter[0];     
        
    }
    
    // returns the 单边的最长，包括root自己的长度
    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        
        max[0] = Math.max(left + right, max[0]);
        
        return Math.max(left, right) + 1;
    } 
}