public class main0107 {
    
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
class Solution0107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> levels = new LinkedList<>();
        if (root == null) return levels;
        
        Deque<TreeNode> queue = new ArrayDeque<>();      
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLayer = new ArrayList<>();
            while (size-- > 0) {
                TreeNode tmp = queue.pollFirst();
                if (tmp.left != null) {
                    queue.offerLast(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offerLast(tmp.right);
                }
                curLayer.add(tmp.val);
            }
            levels.addFirst(curLayer);
        }    
        return levels;
    }
}