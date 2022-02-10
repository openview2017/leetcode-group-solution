/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
Memory Usage: 44.1 MB, less than 5.80% of Java online submissions for Path Sum.
*/
class Solution {
    public boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && target == root.val) {
                return true;
        }
        
        boolean left = hasPathSum(root.left, target - root.val);
        boolean right = hasPathSum(root.right, target - root.val);

        return left || right;

    }
}