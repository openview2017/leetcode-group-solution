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
 * } 00
 1. find node and return path in sb, o(height ~ n)
 2. find prefix index o(n)
 3. process the left and right, o(n)
 
 tc/sc: o(n) - num of nodes
 */
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // 1.search
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        searchNode(root, startValue, sb1);
        searchNode(root, destValue, sb2);
        sb1.reverse();
        sb2.reverse();
        // 2. find prefix;
        int startIndex = findPrefix(sb1, sb2);
        startIndex = startIndex >= 0 ? startIndex : 0;
        // System.out.println(startIndex);
          //System.out.println(sb1.toString());
        // //System.out.println(sb1.toString().substring(startIndex));
         //System.out.println(sb2.toString());
        //System.out.println(sb2.toString().substring(startIndex));
        // 3. post process. a. rev and replace with U for startNode, b. 
        StringBuilder sbRes = new StringBuilder();
        for (int i = startIndex; i < sb1.length(); i++) {
            sbRes.append("U");
        }
        if (sb2.length() > 0) {
            for (int i = startIndex; i < sb2.length(); i++) {
                sbRes.append(sb2.charAt(i));
            }            
        }

        return sbRes.toString();
    }
    
    private boolean searchNode(TreeNode root, int target, StringBuilder sb) {
        if (root.val == target) {
            return true;
        } 
        if (root.left != null && searchNode(root.left, target, sb)) {
            sb.append('L');
        } else if (root.right != null && searchNode(root.right, target, sb)) {
            sb.append('R');
        }
        return sb.length() > 0;
    }
    
    private int findPrefix(StringBuilder sb1, StringBuilder sb2) {
        int limit = Math.min(sb1.length(), sb2.length());
        for (int i = 0; i < limit; i++) {
            if (sb1.charAt(i) != sb2.charAt(i)) {
                return i;
            }
        }
        return limit;
    }
}