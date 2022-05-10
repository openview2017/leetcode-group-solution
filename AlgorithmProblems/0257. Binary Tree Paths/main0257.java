public class main0257 {
    
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution0257 {
    public List<String> binaryTreePaths(TreeNode root) {
      LinkedList<String> paths = new LinkedList();
      if (root == null)
        return paths;
  
      LinkedList<TreeNode> node_stack = new LinkedList();
      LinkedList<String> path_stack = new LinkedList();
      node_stack.add(root);
      path_stack.add(Integer.toString(root.val));
      TreeNode node;
      String path;
      while ( !node_stack.isEmpty() ) {
        node = node_stack.pollLast();
        path = path_stack.pollLast();
        if ((node.left == null) && (node.right == null))
          paths.add(path);
        if (node.left != null) {
          node_stack.add(node.left);
          path_stack.add(path + "->" + Integer.toString(node.left.val));
        }
        if (node.right != null) {
          node_stack.add(node.right);
          path_stack.add(path + "->" + Integer.toString(node.right.val));
        }
      }
      return paths;
    }
  }


class Solution0257_resursion {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)  return res;
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, root);
        return res;
    }
    private void dfs(List<String> res, StringBuilder sb, TreeNode root) {
        if (root == null) return;
        
        int origSize = sb.length();
        sb.append(Integer.toString(root.val));
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
        }
        
        dfs(res, sb, root.left);
        dfs(res, sb, root.right);
        sb.delete(origSize, sb.length());
    }
}
/*
  public List<String> binaryTreePaths(TreeNode root) {
    LinkedList<String> paths = new LinkedList();
    if (root == null)
      return paths;

    LinkedList<TreeNode> node_stack = new LinkedList();
    LinkedList<String> path_stack = new LinkedList();
    node_stack.add(root);
    path_stack.add(Integer.toString(root.val));
    TreeNode node;
    String path;
    while ( !node_stack.isEmpty() ) {
      node = node_stack.pollLast();
      path = path_stack.pollLast();
      if ((node.left == null) && (node.right == null))
        paths.add(path);
      if (node.left != null) {
        node_stack.add(node.left);
        path_stack.add(path + "->" + Integer.toString(node.left.val));
      }
      if (node.right != null) {
        node_stack.add(node.right);
        path_stack.add(path + "->" + Integer.toString(node.right.val));
      }
    }
    return paths;
  }
  */