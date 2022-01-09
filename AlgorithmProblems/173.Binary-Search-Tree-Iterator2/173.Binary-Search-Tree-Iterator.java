/*
constructor: 把tree的最左边一条加进stack O（height）
hasNext：看stack是否为空 O(1)
next：stack pop出来的第一个为next，但是走一个cur = cur.right,然后再把所有的cur.left加进入stack - 这里时间复杂度为？是average 1吗

Runtime: 15 ms, faster than 76.29% of Java online submissions for Binary Search Tree Iterator.
Memory Usage: 42.5 MB, less than 82.03% of Java online submissions for Binary Search Tree Iterator.


*/
class BSTIterator {
    Deque<TreeNode> stack;
    TreeNode cur;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        while (root != null) {
            stack.offerFirst(root);
            root = root.left;
        }
    }
    
    public int next() {
        int next = 0;
        if (hasNext()) {
            cur = stack.pollFirst();
            next = cur.val;
        }
        cur = cur.right;
        while (cur != null) {
            stack.offerFirst(cur);
            cur = cur.left;
        }
        return next;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
