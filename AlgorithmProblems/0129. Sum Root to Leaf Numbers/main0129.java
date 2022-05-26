public class main0129 {
    
}

class Solution0129 {
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[]{0};
        helper(root, 0, sum);
        return sum[0];
    }
    
    private void helper(TreeNode root, int curSum, int[] sum) {
        if (root == null) return;
        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) sum[0] += curSum;
        helper(root.left, curSum, sum);            
        helper(root.right, curSum, sum);
    }
}