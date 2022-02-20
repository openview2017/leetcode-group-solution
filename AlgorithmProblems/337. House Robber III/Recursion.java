class Solution {
    public int rob(TreeNode root) {
        int[] res = helper(root); // 0 is rob, 1 is not rob the current root
        return Math.max(res[0], res[1]);
    }
    
    // helper的物理意义是：给定一个root，rob本node的最大值，不rob本node的最大值，都求出来
    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        // if we rob this node, we cannot rob its children
        int rob = root.val + left[1] + right[1];
        // else, we free to choose rob its children or not
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[] {rob, notRob};
    }
}