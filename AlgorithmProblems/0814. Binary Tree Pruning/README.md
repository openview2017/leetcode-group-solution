# 814. Binary Tree Pruning

把树上所有的非 1 节点都减掉，保留路径上的节点。

![Untitled](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/06/1028_1.png)

---

## Recursive Solution

- Post-order 遍历，自底向上处理。

Python

```python
class Solution:
    def pruneTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return root
        
        root.left = self.pruneTree(root.left)
        root.right = self.pruneTree(root.right)
        
        if root.val == 1 or root.left or root.right:
            return root
        else:
            return None
```

Java

```java
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // 后序遍历位置，判断自己是否是值为 0 的叶子节点
        if (root.val == 0 && root.left == null && root.right == null) {
            // 返回值会被父节点接收，相当于把自己删掉了
            return null;
        }
        // 如果不是，正常返回
        return root;
    }
}
```

Ref

- [花花酱 LeetCode 814. Binary Tree Pruning – Huahua’s Tech Road (mytechroad.com)](https://zxi.mytechroad.com/blog/tree/leetcode-814-binary-tree-pruning/)