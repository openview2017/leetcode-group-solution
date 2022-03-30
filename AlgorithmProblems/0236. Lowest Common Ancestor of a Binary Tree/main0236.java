public class main0236 {
    
}

/*
                                           (3,6,8)-> (3)
                         (6)   /                               \ (8) 
                  (5,6,8)                                     ()
                  (6)  /      \ (#)
          (6,6,8)           (2,6,8)
                         (#)   /      \ (#)
                        (7,6,8)   (4,6,8)
                        (#)  /  \  (#)
*/

class solution0236 {
    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root; // found at both
        return left != null ? left : right; // found @ only one child
    } // lca(root, p, null) -> p

    public TreeNode lowestCommonAncestorIter(TreeNode root, TreeNode p, TreeNode q) {
        // Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        // 1. HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // 2. Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // 3. The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }

}