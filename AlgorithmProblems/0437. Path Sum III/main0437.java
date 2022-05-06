public class main0437 {
    
}

class Solution0437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int[] count = new int[]{0};
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(root, map, targetSum, 0, count);
        return count[0];
    }
    
    private void helper(TreeNode root, Map<Integer, Integer> map, int targetSum, int curSum, int[] count) {
        if (root == null) {
            return;
        }
        
        curSum += root.val;
        count[0] += map.getOrDefault(curSum - targetSum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        helper(root.left, map, targetSum, curSum, count);
        helper(root.right, map, targetSum, curSum, count);
        map.put(curSum, map.get(curSum) - 1);

    }
}
// tc: o(n), sc: O(n)