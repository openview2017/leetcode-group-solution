class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        int[] maxPathSum = new int[] {Integer.MIN_VALUE};
        maxSinglePathSum(root, maxPathSum);
        return maxPathSum[0];
        //following method will return max single path from root top down
        // return maxSinglePathSum(root, maxPathSum);
    }

    private int maxSinglePathSum(TreeNode root, int[] maxPathSum) {
        if (root == null) {
            return 0;
        }

        int left = maxSinglePathSum(root.left, maxPathSum);
        int right = maxSinglePathSum(root.right, maxPathSum);

        //consider if we must pass by current root, what is the path sum,
        //compare pathsum pass current root with global maxPathSum
        maxPathSum[0] = Math.max(left + right + root.val, maxPathSum[0]);

        //choose either left or right single path to return(including current root)
        //abord if single path sum is negetive, just return 0 instead
        return Math.max(0, Math.max(left, right) + root.val) ;
    }
}