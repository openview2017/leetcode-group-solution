class Solution {
    // DFS
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    private void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }
        
        if (res.size() == level) {
            res.add(root.val);
        }
        dfs(root.right, res, level + 1);
        dfs(root.left, res, level + 1);
    }
}

class Solution2 {
    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q= new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        
        if(root == null) return res;
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i< size; i++){
                TreeNode node = q.poll();
                if(i == 0) res.add(node.val);
                if(node.right != null) q.offer(node.right);
                if(node.left != null) q.offer(node.left);
            }
        }
        return res;
    }
}