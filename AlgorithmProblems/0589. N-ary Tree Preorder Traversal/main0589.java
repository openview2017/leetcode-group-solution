public class main0589 {
    
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

class Solution0589 {
    public List<Integer> preorder(Node root) {
        Deque<Node> s = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        s.offerLast(root);
        
        while (!s.isEmpty()) {
            Node curr = s.pollLast();
            res.add(curr.val);
            if (curr.children != null) {
                for (int i = curr.children.size() - 1; i >= 0; i--) {
                    s.offerLast(curr.children.get(i));
                }
            }
        }
        return res;
    }
}