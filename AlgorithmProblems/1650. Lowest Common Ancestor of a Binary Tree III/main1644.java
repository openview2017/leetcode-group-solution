public class main1644 {
    
}


class Solution1650_1 {
    public Node lowestCommonAncestor(Node p, Node q) {
        int pDepth = getDepth(p); 
        int qDepth = getDepth(q);
        
        Node x = pDepth < qDepth ? p : q;
		Node y = pDepth < qDepth ? q : p;
		
        int diff = Math.abs(qDepth - pDepth);
        while(diff-- > 0) {
            y = y.parent;
        }
        
        while(x != y) {
            x = x.parent;
            y = y.parent;
        }
        
        return x;
    }
    
    private int getDepth(Node node) {
        if (node == null) return 0;
        int count = 0; 
        while(node != null) {
            node = node.parent;
            count++;
        }
        
        return count;
    }
}



class Solution1650_2 {
    public Node lowestCommonAncestor0(Node p, Node q) {
        Set<Node> set = new HashSet();
        while(p!=null){
            if(set.contains(p)) return p;
            set.add(p);
            p = p.parent;
            Node t = p;
            p = q;
            q = t;
        }
        
        while(q!=null){
            if(set.contains(q)) return q;
            // set.add(q);
            q = q.parent;
        }
        return null;
    }

/* Proofs: Leetcode 160, two pointers */
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while (a != b) {
            a = a == null? q : a.parent;
            b = b == null? p : b.parent;    
        }
        return a;
    }
}





class Solution1650_3 { // DFS
    public Node lowestCommonAncestor(Node p, Node q) {
        Node root = p;
        while(root.parent != null) {
            root = root.parent;
        }
        return helper(root, p, q);
    }
    Node helper(Node root, Node p, Node q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        
        Node left = helper(root.left, p, q);
        Node right = helper(root.right, p, q);
        if (left != null && right != null) return root;
        if (left == null && right != null) return right;
        if (left != null && right == null) return left;
        return null;
    }
}


