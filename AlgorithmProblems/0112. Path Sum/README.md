# LeetCode 112. Path Sum

Binary Tree，问有没有一条从 Root 到 Leaf 的路径和为 target，返回 boolean。

[Path Sum - LeetCode](https://leetcode.com/problems/path-sum/)

# Recursion

- 时间复杂度：O(N)，N 是树的节点数。对每个节点访问一次。
- 空间复杂度：O(Height)
  - 空间复杂度主要取决于递归时栈空间的开销，最坏情况下，树呈现链状，空间复杂度为 O(N)。
  - 平均情况下树的高度与节点数的对数正相关，空间复杂度为 O(logN)。

Java

```java
class Solution {
    public boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        
        if (root.left == null && root.right == null) {
            return target == root.val;
        }
        
        return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val);
    }
}
```

# BFS

使用两个队列，分别存储将要遍历的节点，以及 Root 到这些节点的路径和

- 时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
- 空间复杂度：O(N)，其中 N 是树的节点数。
  - 空间复杂度主要取决于队列的开销，队列中的元素个数不会超过树的节点数。

Java

```java
class Solution {
    public boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        nodeQueue.offer(root);
        valQueue.offer(root.val);
        
        while(!nodeQueue.isEmpty()) {
            TreeNode curr = nodeQueue.poll();
            int temp = valQueue.poll();
            if (curr.left == null && curr.right == null) {
                if (temp == target) {
                    return true;
                }
                continue;
            }
            
            if (curr.left != null) {
                nodeQueue.offer(curr.left);
                valQueue.offer(curr.left.val + temp);
            }
            
            if (curr.right != null) {
                nodeQueue.offer(curr.right);
                valQueue.offer(curr.right.val + temp);
            }
        }
        
        return false;
    }
}
```

Python

```python
class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if not root:
            return False
        que_node = collections.deque([root])
        que_val = collections.deque([root.val])
        while que_node:
            now = que_node.popleft()
            temp = que_val.popleft()
            if not now.left and not now.right:
                if temp == sum:
                    return True
                continue
            if now.left:
                que_node.append(now.left)
                que_val.append(now.left.val + temp)
            if now.right:
                que_node.append(now.right)
                que_val.append(now.right.val + temp)
        return False
```