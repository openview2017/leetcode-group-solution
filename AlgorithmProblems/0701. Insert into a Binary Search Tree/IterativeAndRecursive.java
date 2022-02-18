// Iterative
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == val) {
                return root;
            } else if (cur.val < val) {
                if (cur.right == null) { // 向下看一眼
                    cur.right = new TreeNode(val);
                    break;
                }
                cur = cur.right;
            } else {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    break;
                }
                cur = cur.left;
            }
        }
        return root;
        
    }
}

// Recursive
class Solution {
    public TreeNode insert(TreeNode root, int key) {
      // recursion
      if (root == null) {
        return new TreeNode(key);
      }
      if (root.key > key) {
        root.left = insert(root.left, key);
      } else if (root.key < key) {
        root.right = insert(root.right, key);
      }
      return root;
    }
  }
  