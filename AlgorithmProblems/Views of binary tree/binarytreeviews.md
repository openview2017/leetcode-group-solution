# Top view

```java


```

# Right View
## recursive
``` java



```
## iterative
``` java


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