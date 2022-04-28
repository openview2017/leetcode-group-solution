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
/*abstract
      1
      /\
     2  3
     /
    4 
 inorder: [root.left] root.val [root.right] 
 inorder: 4,2, 1, 3

 preorder: root.val [root.left]  [root.right] 
 inorder: 1,2,4,3


 1. recursion input: root of tree, out: List<Integer> inorder
    base: root == null 
    tc: o(n), sc: o(height)

 2. iteration: sc: o(height)
    stack<TreeNode>
    List<Integer>: 4,2,1,3
    curNode: 
    stack: 




*/