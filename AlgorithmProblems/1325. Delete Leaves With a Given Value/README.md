# **1325. Delete Leaves With a Given Value**

1325 删除给定值的叶子节点  [Delete Leaves With a Given Value - LeetCode](https://leetcode.com/problems/delete-leaves-with-a-given-value/)

输入：`BinaryTree` root，`int` target

输出：

- 从 Binary Tree 中删除所有值为 target 的 leaf node
- 如果删除一个 leaf 之后，其父亲也变为 leaf node，如果此父节点的值也为 target，那么也删除。重复直到不能删除。

![Untitled](https://assets.leetcode.com/uploads/2020/01/09/sample_1_1684.png)

# Recursive

see also [**814. Binary Tree Pruning**](https://github.com/openview2017/leetcode-group-solution/tree/bbd2610f84a045f4d07ca80fc4027699ebf8f3c5/AlgorithmProblems/0814.%20Binary%20Tree%20Pruning)

- Post-order 遍历，自底向上处理
- 看一下左右孩子的返回值，就可以直到自己是不是新的 leaf

Complexity Analysis:
- Time Complexity: O(n)
- Space Complexity:  O(height)

Java

```java
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        
        // 删除操作：
        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        
        return root;
    }
}
```

Python

```python
class Solution:
    def removeLeafNodes(self, root: TreeNode, target: int) -> TreeNode:
        if not root:
            return None
        root.left = self.removeLeafNodes(root.left, target)
        root.right = self.removeLeafNodes(root.right, target)
        if not root.left and not root.right and root.val == target:
            return None
        return root
```

