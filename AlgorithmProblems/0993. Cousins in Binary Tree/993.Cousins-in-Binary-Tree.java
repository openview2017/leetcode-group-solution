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

class Solution0993_bfs {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] xi = bfs(root, x);
        int[] yi = bfs(root, y);
        return xi[1] == yi[1] && xi[0] != yi[0];
    }
    int[] bfs(TreeNode root, int t) {
        Deque<Object[]> d = new ArrayDeque<>(); // 存储值为 [cur, fa, depth]
        d.addLast(new Object[]{root, null, 0});
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                Object[] poll = d.pollFirst();
                TreeNode cur = (TreeNode)poll[0], fa = (TreeNode)poll[1];
                int depth = (Integer)poll[2];

                if (cur.val == t) return new int[]{fa != null ? fa.val : 0, depth};
                if (cur.left != null) d.addLast(new Object[]{cur.left, cur, depth + 1});
                if (cur.right != null) d.addLast(new Object[]{cur.right, cur, depth + 1});
            }
        }
        return new int[]{-1, -1};
    }
}


class Solution0993_dfs {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] xinfo = dfs(root, null, 0, x);
        int[] yinfo = dfs(root, null, 0, y); // [parent.val, level]
        return xinfo[1] == yinfo[1] && xinfo[0] != yinfo[0];
    }
    
    private int[] dfs(TreeNode curNode, TreeNode pa, int level, int target) {
        if (curNode == null) return new int[]{-1, -1};
        if (curNode.val == target) {
            int paVal = pa!=null ? pa.val : 1; // why 1?
            return new int[]{paVal, level};
        }
        int[] left = dfs(curNode.left, curNode, level+1, target);
        if (left[0] != -1) return left;
        return dfs(curNode.right, curNode, level+1, target);
    }
}