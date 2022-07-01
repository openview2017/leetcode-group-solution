public class main0426 {
    
}


class Solution0426 { // tc:o(n), sc: O(n)
    Node first = null;
    Node last = null;
    
    public Node treeToDoublyList(Node root) {
        helper(root);
        if (first != null && last != null) {
            last.right = first;
            first.left = last; // pay attention to direction
        }
        return first;
    }
    
    private void helper(Node root) {
        if (root == null) return;
        helper(root.left);
        // cur
        if (last != null) {
            last.right = root;
            root.left = last;
        } else {
            first = root;
        }
        last = root;
        //
        helper(root.right);
    }
}