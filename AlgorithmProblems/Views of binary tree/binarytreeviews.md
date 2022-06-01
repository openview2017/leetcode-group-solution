# Top view

```java
/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public List<Integer> topView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    // help with level order traversal
    Queue<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(root, 0));
    // store temp result
    // if node's column is less than left range, append at head
    // if node's column is larger than right range, append at tail
    Deque<Integer> deque = new ArrayDeque<>();
    deque.offerFirst(root.key);
    // store the current column range from left most to right most
    int[] range = new int[]{0,0};
    while(! queue.isEmpty()) {
      Pair cur = queue.poll();
      if (cur.node.left != null) {
        // compute column of left child
        int col = cur.col - 1;
        if (col < range[0]) {
          // add this new left most node to head of deque
          deque.addFirst(cur.node.left.key);
          // update range
          range[0] = col;
        }
        queue.add(new Pair(cur.node.left, col));
      }
      if (cur.node.right != null) {
        int col = cur.col + 1;
        if (col > range[1]) {
          deque.addLast(cur.node.right.key);
          range[1] = col;
        }
        queue.add(new Pair(cur.node.right, col));
      }
    }
    // mode to result list
    while(! deque.isEmpty()) {
      res.add(deque.pollFirst());
    }
    return res;
  }

  class Pair {
    TreeNode node;
    int col;
    public Pair(TreeNode node, int col) {
      this.node = node;
      this.col = col;
    }
  }

}


```

# Right View
## recursive
``` java
class Solution {
    List<Integer> rightside = new ArrayList();
    
    public void helper(TreeNode node, int level) {
        if (level == rightside.size()) 
            rightside.add(node.val);
        
        if (node.right != null) 
            helper(node.right, level + 1);  
        if (node.left != null) 
            helper(node.left, level + 1);
    }    
    
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside;
        
        helper(root, 0);
        return rightside;
    }
}


```
## iterative
``` java
public class Solution {
  public List<Integer> rightView(TreeNode root) {
    // Write your solution here
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int count = queue.size();
      for (int i = 0; i < count; i++) {
        TreeNode tmp = queue.poll();
        if (tmp.left != null) {
          queue.offer(tmp.left);       
        }        
        if (tmp.right != null) {
          queue.offer(tmp.right);                    
        }
        if (i == count - 1) {
          result.add(tmp.key);
        }
      }    
    }
    return result;
  }
}

```

# Boundary

``` java
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
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<Integer> leftBound = new LinkedList<>();
        List<Integer> rightBound = new LinkedList<>();
        List<Integer> leaf = new LinkedList<>();
        res.add(root.val);
        helper(root, 0, leftBound, rightBound, leaf);
        res.addAll(leftBound);
        System.out.println("left:" + Arrays.toString(leftBound.toArray()));
        res.addAll(leaf);
        System.out.println("right:" + Arrays.toString(rightBound.toArray()));
        res.addAll(rightBound); // 0-root, 1-left, 2-right, 3-leaf, 4-other
        return res;
    }
    
    private void helper(TreeNode root, int type, List<Integer> leftBound, List<Integer> rightBound, List<Integer> leaf) { // preorder
        if (root == null) {
            return;
        }
        
        if (type == 1) {
            leftBound.add(root.val);
        } else if (type == 2) {
            rightBound.add(0, root.val); //
        } else if (type != 0 && root.left == null && root.right == null) {
            leaf.add(root.val);
        }
        
        helper(root.left, leftType(root, type), leftBound, rightBound, leaf);
        helper(root.right, rightType(root, type), leftBound, rightBound, leaf);        
    }
    
    private int leftType(TreeNode cur, int type) {
        if (type == 0 || type == 1) {
            return 1;
        } else if (type == 2 && cur.right == null) {
            return 2;
        }
        return 4;
    }
 
    private int rightType(TreeNode cur, int type) {
        if (type == 0 || type == 2) {
            return 2;
        } else if (type == 1 && cur.left == null) {
            return 1;
        }
        return 4;
    }
}

```