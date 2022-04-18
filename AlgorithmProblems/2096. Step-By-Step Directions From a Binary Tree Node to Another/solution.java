/*
step 1: find lca
step 2: start from lca, find the two nodes, build the path at the same time
step 3: build the overall path

*/
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode node = getLCA(root, startValue, destValue);
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        findStart(node, startValue, sb1);
        findDest(node, destValue, sb2);
        
        return sb1.toString() + sb2.reverse().toString();
    }

    private boolean findStart(TreeNode node, int value, StringBuilder sb) {
        if (node == null) {
            return false;
        }

        if (node.val == value) {
            return true;
        } 
        
        boolean left = findStart(node.left, value, sb);
        boolean right = findStart(node.right, value, sb);

        if (left || right) {
            sb.append("U");
        }
        
        return left || right;
    }

    private boolean findDest(TreeNode node, int value, StringBuilder sb) {
        if (node == null) {
            return false;
        }

        if (node.val == value) {
            return true;
        } 
        
        boolean left = findDest(node.left, value, sb);
        boolean right = findDest(node.right, value, sb);
        
        if (left) {
            sb.append("L");
        } else if (right) {
            sb.append("R");
        }
        
        return left || right;
    }
    
    
    private TreeNode getLCA(TreeNode root, int one, int two) {
        if (root == null || root.val == one || root.val == two) {
            return root;
        }
        
        TreeNode left = getLCA(root.left, one, two);
        TreeNode right = getLCA(root.right, one, two);
        
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}