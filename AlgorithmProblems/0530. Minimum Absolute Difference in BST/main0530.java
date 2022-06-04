public class main0530 {
    
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
public class Solution0530_r {
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        
        getMinimumDifference(root.left);
      
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        
        getMinimumDifference(root.right);
        
        return min;
    }    
}

public class Solution0530_i {
    public int getMinimumDifference(TreeNode root) {
        int minDif = Integer.MAX_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerLast(cur);
                cur = cur.left;
            } else {
                cur = stack.pollLast();
                if (prev != null) {
                    minDif = Math.min(minDif, cur.val - prev.val);
                }
                prev = cur;
                cur = cur.right;
            }
        }
        return minDif;
    }
}
// public class Solution {
//     TreeSet<Integer> set = new TreeSet<>();
//     int min = Integer.MAX_VALUE;
    
//     public int getMinimumDifference(TreeNode root) {
//         if (root == null) return min;
        
//         if (!set.isEmpty()) {
//             if (set.floor(root.val) != null) {
//                 min = Math.min(min, root.val - set.floor(root.val));
//             }
//             if (set.ceiling(root.val) != null) {
//                 min = Math.min(min, set.ceiling(root.val) - root.val);
//             }
//         }
        
//         set.add(root.val);
        
//         getMinimumDifference(root.left);
//         getMinimumDifference(root.right);
        
//         return min;
//     }
// }