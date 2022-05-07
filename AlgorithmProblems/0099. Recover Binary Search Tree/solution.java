// TC:O(n)
// SC:O(height)
class Solution {
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        recover(root);
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }
    
    private void recover(TreeNode root) {
        if (root == null) {
            return;
        }
        recover(root.left);
        if (firstNode == null && root.val < preNode.val) {
            firstNode = preNode;
        }
        if (firstNode != null && root.val < preNode.val) {
            secondNode = root;
        }
        preNode = root;
        recover(root.right);
    }
}

class Solution0099_2 { //iterative
    public void swap(TreeNode a, TreeNode b) {
      int tmp = a.val;
      a.val = b.val;
      b.val = tmp;
    }
  
    public void recoverTree(TreeNode root) {
      Deque<TreeNode> stack = new ArrayDeque();
      TreeNode x = null, y = null, pred = null;
  
      while (!stack.isEmpty() || root != null) {
        while (root != null) {
          stack.add(root);
          root = root.left;
        }
        root = stack.removeLast();
        if (pred != null && root.val < pred.val) {
          y = root;
          if (x == null) x = pred;
          else break;
        }
        pred = root;
        root = root.right;
      }
  
      swap(x, y);
    }
  }