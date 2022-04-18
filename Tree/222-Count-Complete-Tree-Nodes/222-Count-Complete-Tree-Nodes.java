class Solution {
    /**
     * 解题思路： 利用完全二叉树的特性，和完美二叉树的特性。
     * 完美二叉树的node数目为 2**h - 1 ， h为树的高度。
     * 完全二叉树的有两种情况：
     * case 1: lh == rh,  左边子树是完美二叉树，node数量是 2**lh - 1 ，只需要计算右边子树叶子结点数量， 总数为： （1 << lh） - 1 + 1（root） + countNodes(root.right)
     * case 2: lh != rh,  右边子树是完美二叉树，node数量是 2**rh - 1 ，只需要计算左边边子树叶子结点数量,总数为： （1 << (rh)） - 1 + 1（root） + countNodes(root.right)
     * 
     * 参考： https://www.youtube.com/watch?v=dtLIe1rHYPg
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        
        int res = 0;
        if (lh == rh) {
            res = (1 << lh) + countNodes(root.right); // left sub tree is perfect binary tree, nodes count: 2**lh - 1
        } else {
            res = (1 << (lh - 1)) + countNodes(root.left); // right sub tree is perfect binary tree, nodes: 2**(lh -1) -1
        }
        
        return res ;
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + getHeight(node.left);
    }
}