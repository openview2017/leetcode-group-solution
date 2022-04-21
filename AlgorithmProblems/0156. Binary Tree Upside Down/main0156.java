public class main0156 {
    public static void main(String[] args) {
        Solution0156 sol = new Solution0156();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode cur = root;
        cur = cur.left;
        cur.left = new TreeNode(4);
        cur.right = new TreeNode(5);        
        TreeNode res = sol.upsideDownBinaryTree(root);
        System.out.println(root.val);
        System.out.println(res.val);
    }
}

class Solution0156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.right = root;
        root.left.left = root.right;
        root.left = null;
        root.right = null;
        
        return newRoot;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
