public class main0222 {
    public static void main(String[] args) {
        
    }
}

class Solution0222 {
    public int countNodes(TreeNode root) {
        //int curHeight = getHeight(root);
        if (root == null) return 0;
        //int count = 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << (left+1)); // correct
        }
        return countNodes(root.left) + (1 << (right+1)); // left > right
    }
    
    private int getHeight(TreeNode root) { // leave h == 0,  # nodes = 2^h - 1
        if (root == null) return -1;
        return getHeight(root.left) + 1;
    }
}