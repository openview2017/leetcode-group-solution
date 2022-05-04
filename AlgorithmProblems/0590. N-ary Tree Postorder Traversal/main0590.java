public class main0590 {
    
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution0590 {
    public List<Integer> postorder(Node root) {
        Deque<Node> stack = new ArrayDeque<>();                   LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pollLast();
            res.addFirst(curr.val);
            for (Node n : curr.children) {
                if (n != null) {
                    stack.offerLast(n);
                }
            }
        }
        return res;
    }
    // recursion method
    public List<Integer> postorderRec(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }
    private void helper(Node root, LinkedList<Integer> res) {
        if (root == null) return;
        res.addFirst(root.val);
        int size = root.children.size();
        for (int i = size - 1; i >= 0; i--) {
            helper(root.children.get(i), res);
        }
    }    
}