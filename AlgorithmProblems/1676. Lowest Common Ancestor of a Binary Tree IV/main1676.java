public class main1676 {
    
}

class Solution1676 { // need iterative method
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
    Set<TreeNode> set = new HashSet<TreeNode>();
    for (TreeNode n : nodes) set.add(n);
    return helper(root, set);
  }
  private TreeNode helper(TreeNode root, Set<TreeNode> set) {
    // base case
    if (root == null || set.contains(root)) {
      return root;
    }
    TreeNode lr = helper(root.left, set);
    TreeNode rr = helper(root.right, set);
    if (lr != null && rr != null) {
      return root;
    }
    return lr != null ? lr : rr;
  }
}

