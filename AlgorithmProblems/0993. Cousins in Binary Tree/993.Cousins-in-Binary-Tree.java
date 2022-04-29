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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean xExist = false;
            boolean yExist = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == x) xExist = true;
                if (cur.val == y) yExist = true;
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == x && cur.right.val == y 
                       || cur.right.val == x && cur.left.val == y) {
                        return false;//same parent
                    }
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            //if x, y is in same level, true
            if (xExist && yExist) return true;
        }
        
        return false;
    }
    
}
