class Solution1 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (root == null) {
            return res;
        }
        cur.add(root.val);
        helper(root, targetSum, cur, res);
        return res;
    }
    
    private void helper(TreeNode root, int target, List<Integer> cur, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null && root.val == target) {
            res.add(new ArrayList(cur));
            return;
        }
        
        if (root.left != null) {
            cur.add(root.left.val);
            helper(root.left, target - root.val, cur, res);
            cur.remove(cur.size() - 1);
        }
        
        if (root.right != null) {
            cur.add(root.right.val);
            helper(root.right, target - root.val, cur, res);
            cur.remove(cur.size() - 1);            
        }
       
    }
}

class Solution2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, targetSum, cur, res);
        return res;
    }
    
    private void helper(TreeNode root, int target, List<Integer> cur, List<List<Integer>> res) {
        cur.add(root.val);
        if (root.left == null && root.right == null && root.val == target) {
            res.add(new ArrayList(cur));
        }
        
        if (root.left != null) {
            helper(root.left, target - root.val, cur, res);
        }
        
        if (root.right != null) {
            helper(root.right, target - root.val, cur, res);
        }
        cur.remove(cur.size() - 1);
       
    }
}