/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
Memory Usage: 41.9 MB, less than 40.57% of Java online submissions for Validate Binary Search Tree.
TC: O(n)
SC: O(height)
corner case:
 1. root.val <= min && root.val >= max -> faslse, 要记得等于也是false
 2. 用了Integer min and max， 如果tree里有这个数就不太行。应该用Long.MIN_VALUE and Long.MAX_VALUE
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        } 
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}