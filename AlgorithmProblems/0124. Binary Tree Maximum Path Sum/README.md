# 124. Binary Tree Maximum Path Sum
124 二叉树中的最大路径和

- input：Tree
- output：
  - 不回头不重复，any to any path
  - 返回最大的 path sum 是多少


![](https://assets.leetcode.com/uploads/2020/10/13/exx2.jpg)

```java
输入：root = [-10,9,20,null,null,15,7]
输出：42
解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
```

see also [**687. Longest Univalue Path**]([leetcode-group-solution/AlgorithmProblems/0687. Longest Univalue Path at main · openview2017/leetcode-group-solution (github.com)](https://github.com/openview2017/leetcode-group-solution/tree/main/AlgorithmProblems/0687. Longest Univalue Path))

# Recursion

*Linghan Ye - June 2nd 2022*

Recursive 的计算二叉树中每个节点的最大贡献值：

- 空 node 返回 0
- 非空：子节点的最大贡献值之和

eg.

```java
括号中为节点的返回值

    -10 (-10 + max(35, 9) = 25)
   /   \
(9)9     20 (20 + max(15, 7) = 35)
        /  \
  (15) 15   7 (7)
```

Complexity Analysis:

- Time Complexity: O(n)
  - 对每个节点访问不超过 2 此
- Space Complexity: O(height)

Java

```java
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        helper(root, result);
        return result[0];
    }
    
    private int helper(TreeNode node, int[] result) {
        if (node == null) {
            return 0;
        }
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(helper(node.left, result), 0);
        int rightGain = Math.max(helper(node.right, result), 0);
        
        int cur = node.val + leftGain + rightGain;
        
        result[0] = Math.max(result[0], cur);
        
				// 返回节点的最大贡献值        
        return node.val + Math.max(leftGain, rightGain);
    }
}
```