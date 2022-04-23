public class main0145 {
    
}

class Solution0145 {
    public List<Integer> postorderTraversalIter1(TreeNode root) {
        LinkedList<Integer> postorder = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                postorder.addFirst(cur.val);
                cur = cur.right;
            } else {
                cur = stack.pollFirst();
                cur = cur.left;
            }
        }
        return postorder;
    }

    public List<Integer> postorderTraversalIter2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return output;
    }
}