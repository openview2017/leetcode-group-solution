# **129. Sum Root to Leaf Numbers**

129  求根节点到叶节点数字之和 [Sum Root to Leaf Numbers - LeetCode](https://leetcode.com/problems/sum-root-to-leaf-numbers/)

输入：

- Binary Tree，每个节点都存放有一个 0 到 9 之间的数字。
- 每条从 Root 到 Leef 的路径都代表一个数字

输出：从根节点到叶节点生成的所有数字之和。

```java
输入：root = [4,9,0,5,1]
输出：1026
解释：
 4->9->5 代表数字 495
 4->9->1 代表数字 491
 4->0 代表数字 40
数字总和：495 + 491 + 40 = 1026
```

![Untitled](https://assets.leetcode.com/uploads/2021/02/19/num2tree.jpg)

## DFS

- 从 Root 出发，DFS 遍历所有节点，如果遍历到一个 Leaf，就把 Leaf 所对应到数字 add 到 result 中
- 如果不是 leaf，就计算当前到节点的数字，然后继续 DFS

Complexity Analysis:

- Time Complexity: O(n)
- Space Complexity: O(height)
  - call stack

```java
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
        
    }
    
    private int dfs(TreeNode root, int prev) {
        if (root == null) {
            return 0;
        }
        
        int currentNumber = prev * 10 + root.val;
        
        if (root.left == null && root.right == null) {
            return currentNumber;
        } else {
            return dfs(root.left, currentNumber) + dfs(root.right, currentNumber);
        }
    }
}
```

## BFS

两个队列，分别存储节点和节点对应的数字

BFS 时：

- 如果遇到 leaf，把该节点对应的数字 add 到 result 中
- 如果当前不是 leaf，

Complexity Analysis:

- Time Complexity: O(n)
- Space Complexity: O(n)

```java
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueValue = new LinkedList<Integer>();
        queueNode.offer(root);
        queueValue.offer(root.val);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int num = queueValue.poll();

            TreeNode left = node.left;
            TreeNode right = node.right;
            
            if (left == null && right == null) {
                result += num;
            } else {
                if (left != null) {
                    queueNode.offer(left);
                    queueValue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    queueNode.offer(right);
                    queueValue.offer(num * 10 + right.val);
                }
            }
        }
        return result;
    }
}
```

