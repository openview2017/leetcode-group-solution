public class main0110 {
    
}

class Solution0110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        // left, right subtree is unbalanced or cur tree is unbalanced
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}

class Solution0110Rec2  {
    // Recursively obtain the height of a tree. An empty tree has -1 height
    private int height(TreeNode root) {
      // An empty tree has height -1
      if (root == null) {
        return -1;
      }
      return 1 + Math.max(height(root.left), height(root.right));
    }
  
    public boolean isBalanced(TreeNode root) {
      // An empty tree satisfies the definition of a balanced tree
      if (root == null) {
        return true;
      }
  
      // Check if subtrees have height within 1. If they do, check if the
      // subtrees are balanced
      return Math.abs(height(root.left) - height(root.right)) < 2
          && isBalanced(root.left)
          && isBalanced(root.right);
    }
  };