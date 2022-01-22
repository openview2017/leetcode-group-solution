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

/*
single path max diff
min, max
from root to leave,
    for each node
        max = Math.max(max, root.val), min = Math.min(min, root.val)
        maxDiff = Math.max(max - min);
return maxDiff
*/
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int min, int max) {
        if (root == null) return Math.abs(max - min);
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        int leftMaxDiff = dfs(root.left, min, max);
        int rightMaxDiff = dfs(root.right, min, max);
        return Math.max(Math.max(leftMaxDiff, rightMaxDiff), max - min);
    }
}