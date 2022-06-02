
#  LeetCode 113. Path Sum II

输入：`TreeNode` 二叉树的 root ，`int` 整数 targetSum ，

输出：`int` 该二叉树里节点值之和等于 targetSum 的 路径的数目。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）

```java
Input: 
root = [10,5,-3,3,2,null,11,3,-2,null,1], 
targetSum = 8

Output: 3

Explanation: The paths that sum to 8 are shown.
```

<img src="https://assets.leetcode.com/uploads/2021/04/09/pathsum3-1-tree.jpg" alt="https://assets.leetcode.com/uploads/2021/04/09/pathsum3-1-tree.jpg" style="zoom:50%;" />

# DFS (will be optimized)

LeetCode Accepted

- DFS 穷举所有的可能，访问每一个节点 node，访问以 node 为起始节点且向下延深的所有路径
- 递归遍历每一个节点的所有满足条件的路径，然后将这些路径数目加起来得到返回结果。

Complexity Analysis:

- Time Complexity: $O(n^2)$
  - N 为该二叉树节点的个数
  - 对于每一个节点，求以该节点为起点的路径数目时，则需要遍历以该节点为根节点的子树的所有节点，因此求该路径所花费的最大时间为 O(n)，
  - 我们会对每个节点都求一次以该节点为起点的路径数目，因此时间复杂度为 $O(n^{2})$
- Space Complexity: O(n)
  - call stack space

```java
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        
        int result = dfs(root, targetSum);
        result += pathSum(root.left, targetSum);
        result += pathSum(root.right, targetSum);
        return result;
    }
    
		// 返回：以节点 root 为起点向下且满足路径总和为 target 的路径数目
    private int dfs(TreeNode root, int target) {
        int result = 0;
        
        if (root == null) {
            return 0;
        }
        
        int val = root.val;
        if (val == target) {
            result += 1;
        }
        
        result += dfs(root.left, target - val);
        result += dfs(root.right, target - val);
        
        return result;
    }
}
```

# Prefix Sum

DFS 中存在许多重复计算

定义节点的前缀和为：由根结点到当前结点的路径上所有节点的和。

我们利用 pre-order 遍历二叉树，记录下 root 到当前节点 p 的路径上除当前节点以外所有节点的前缀和

在已保存的路径前缀和中查找是否存在前缀和刚好等于当前节点到根节点的前缀和 curr 减去 targetSum。
