public class main0450 {
    
}

class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode min = searchMin(root.right); //
            root.right = deleteNode(root.right, min.val);
            min.right = root.right;
            min.left = root.left;
            root = min;
        }
        return root;
    }
    
    private TreeNode searchMin(TreeNode root) {
        TreeNode min = root;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }
}