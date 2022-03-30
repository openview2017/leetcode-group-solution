public class main1644 {
    
}


/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/discuss/933835/Java.-Difference-from-236-is-you-need-to-search-the-entire-tree.

Time Complexity: O(N)
Space Complexity: O(H), H is the height of the tree

This question is similar to 236. Last Common Ancestor of Binary Tree. Question 236 has two important premises:
    1. It is guaranteed that both p and q are in the tree.
    2. A node can be a descendant of itself.

But for this question, the premises are different:

It is NOT guaranteed that both p and q are in the tree.
A node can still be a descendant of itself.
Hence,

We need a way to record if we've seen both p and q
We need to traverse the entire tree even after we've found one of them.
*/

class Solution1644_1 {
    boolean pFound = false;
    boolean qFound = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode LCA = LCA(root, p, q);
        return pFound && qFound ? LCA : null;
    }
    
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        TreeNode left = LCA(root.left, p, q);     
        TreeNode right = LCA(root.right, p, q);
        if (root == p) {
            pFound = true;
            return root;
        }
        if (root == q) {
            qFound = true;
            return root;
        }
        return left == null ? right : right == null ? left : root;
    }
}


class Solution1644_2 {
	int count = 0;
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode LCA = LCA(root, p, q);
        return count == 2 ? LCA : null;
    }
    
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        TreeNode left = LCA(root.left, p, q);     
        TreeNode right = LCA(root.right, p, q);
        if (root == p || root == q) {
            count++;
            return root;
        }
        return left == null ? right : right == null ? left : root;
    }
}


/* Iterative solution */
class Solution_3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parents = new HashMap<>(); 
		Stack<TreeNode> stack = new Stack<>();
        parents.put(root, null); 
		stack.push(root);
        while (!stack.isEmpty() && (!parents.containsKey(p) || !parents.containsKey(q))) {
            TreeNode curr = stack.pop();
            if (curr.left != null) {
                parents.put(curr.left, curr); stack.push(curr.left);
            }
            if (curr.right != null) {
                parents.put(curr.right, curr); stack.push(curr.right);
            }
        }
        if(!parents.containsKey(q) || !parents.containsKey(q)){
            return null;
        }
        Set<TreeNode> pAns = new HashSet<>();
        while (p != null) {
            pAns.add(p);
			p = parents.get(p);
        }
        while (!pAns.contains(q))  {
            q = parents.get(q);
            if (q == null) break; // prevent the infinite loop
        }
        return q;
    }
}

