public class main0872 {
    
}

class Solution0872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        helper(root1, l1);        
        List<Integer> l2 = new ArrayList<>();
        helper(root2, l2);
        return l1.equals(l2);
    }
    
    private void helper(TreeNode root, List<Integer> l) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            l.add(root.val);
        }
        helper(root.left, l);        
        helper(root.right, l);
    }
}