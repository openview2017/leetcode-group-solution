class main0094{
    public static void main(String[] args) {
        
    }
}

class solution0094{
    public List<Integer> inorderTraversal(TreeNode root) { // iterative
        List<Integer> inorder = new ArrayList<>();
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                inorder.add(cur.val);
                cur = cur.right;
            }
        }
        return inorder;
    }

    // recurvisely
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
          return res;
        }
        helper(root, res);
        return res;
      }
      private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
          return;
        }
        
        helper(root.left, res);
        res.add(root.key);
        helper(root.right, res);
      }
}