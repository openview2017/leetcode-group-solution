public class main0236 {
    
}


class solution0236 {
    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root; // found at both
        return left != null ? left : right; // found @ only one child
    } // lca(root, p, null) -> p

    
}