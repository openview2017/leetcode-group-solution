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
class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        int[] count = new int[1];
        dfs(root, root.val, count);
        return count[0];
    }

    private void dfs(TreeNode root, int maxPathValue, int[] count) {
        if (root == null) {
            return;
        }
        if (root.val >= maxPathValue) {
            count[0] += 1;
            maxPathValue = root.val;
        }
        // maxPathValue = Math.max(root.val, maxPathValue);
        dfs(root.left, maxPathValue, count);
        dfs(root.right, maxPathValue, count);
    }
}