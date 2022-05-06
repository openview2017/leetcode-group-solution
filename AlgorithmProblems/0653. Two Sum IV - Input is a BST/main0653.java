public class main0653 {
    
}

// reference: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/discuss/1420711/C%2B%2BJavaPython-3-solutions%3A-HashSet-Stack-Python-yield-Solutions-O(H)-space
class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();
    private boolean reverse;
    BSTIterator(TreeNode root, boolean reverse) {
        this.reverse = reverse;
        push(root);
    }
    int next() {
        TreeNode top = st.pop();
        push(!reverse ? top.right : top.left);
        return top.val;
    }
    private void push(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = !reverse ? root.left : root.right;
        }
    }
}

class Solution0653 {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator leftItr = new BSTIterator(root, false);
        BSTIterator rightItr = new BSTIterator(root, true);

        int left = leftItr.next(), right = rightItr.next();
        while (left < right) {
            if (left + right == k) return true;
            if (left + right < k)
                left = leftItr.next();
            else
                right = rightItr.next();
        }
        return false;
    }
}