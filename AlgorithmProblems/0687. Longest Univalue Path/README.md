# **687. Longest Univalue Path**

687 最长同值路径

输入：Binary Tree

输出：最长单一数值的 path 的长度 （-1）

![输出 2](https://assets.leetcode.com/uploads/2020/10/13/ex1.jpg)

输出 2

![输出 2](https://assets.leetcode.com/uploads/2020/10/13/ex2.jpg)

输出 2

# Recursion

*Tang Zhao -  June 2nd, 2022*

任何一条路径，都可以看作两个从 root 向下延伸出的「一」（撇捺）。对于每个节点，需要知道最长的撇和最长的捺是什么。

Bottom Up，每层向下看一下孩子

- 如果左孩子与自己相同，那么当前层撇的长度 + 1
- 右孩子一样处理

Complexity Analysis:

- Time Complexity: O(n)
- Space Complexity: O(height)

```java
class Solution {
    public int longestUnivaluePath(TreeNode root) {
        int[] res = {0};
        helper(root, res);
        return res[0];
    }
    
    private int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        
        int leftStroke = 0;
        int rightStroke = 0;
        
        if (root.left != null && root.left.val == root.val) {
            leftStroke += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightStroke += right + 1;
        }
        
        res[0] = Math.max(res[0], leftStroke + rightStroke);
        return Math.max(leftStroke, rightStroke);
        
    }
}
```

---

另一种 bottom up 写法

```java
class Solution {   
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = {0};
        helper(root, root.val, res);
        return res[0];
    }

    // 定义：计算以 root 为根的这棵二叉树中，从 root 开始值为 parentVal 的最长树枝长度
    private int helper(TreeNode root, int parentVal, int[] res) {
        if (root == null) {
            return 0;
        }
        // 利用函数定义，计算左右子树值为 root.val 的最长树枝长度
        int leftLen = helper(root.left, root.val, res);
        int rightLen = helper(root.right, root.val, res);

        // 后序遍历位置顺便更新全局变量
        // 同值路径就是左右同值树枝长度之和
        res[0] = Math.max(res[0], leftLen + rightLen);
        // 如果 root 本身和上级值不同，那么整棵子树都不可能有同值树枝
        if (root.val != parentVal) {
            return 0;
        }

        // 以 root 为根的二叉树从 root 开始值为 parentVal 的最长树枝长度
        // 等于左右子树的最长树枝长度的最大值加上 root 节点本身
        return  1 + Math.max(leftLen, rightLen);
    }
}
```

