# **2096. Step-By-Step Directions From a Binary Tree Node to Another**

2096 从二叉树一个节点到另一个节点每一步的方向

- 输入：Binary Tree，start，destination
- 输出：从 start 到 destination 的最短路径的每一步的方向

```
Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6

Output: "UURL"

Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
```

![Untitled](https://assets.leetcode.com/uploads/2021/11/15/eg1.png)

*Eason Fan - June 2nd 2022*

# BFS

LeetCode Time Limit Exceeded

- Time Complexity: O(V+E)

将树转换为有向图，Adjacency list

- 2 的邻居：[(6, L), (4, R), (5, U)]
- 1：[(3, L), (5, U)]

然后使用 BFS 寻找最短路径

# Ad-hoc

- 寻找从 root 到 start 的路径，翻转方向
- 寻找从 root 到 destination 的路径
- 将两个路径的公共部分去掉，然后组合起来剩余部分

Complexity Analysis:

- Time Complexity: O(n)
- Space Complexity: O(n)

Python

```python
from collections import deque
class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        start_path, dest_path = deque(), deque()
        
        self.find(root, startValue, [], start_path)
        self.find(root, destValue, [], dest_path)
        
        while start_path and dest_path and start_path[0] == dest_path[0]:
            start_path.popleft()
            dest_path.popleft()
            
        return "U" * len(start_path) + "".join(dest_path)
    
    
    
    def find(self, node, target, path, result):
        if not node:
            return
        
        if node.val == target:
            result.extend(path.copy())
            return
        
        if node.left:
            path.append('L')
            self.find(node.left, target, path, result)
            path.pop()
            
        if node.right:
            path.append('R')
            self.find(node.right, target, path, result)
            path.pop()
```

Java

```java
private boolean find(TreeNode n, int val, StringBuilder sb) {
    if (n.val == val) 
        return true;
    if (n.left != null && find(n.left, val, sb))
        sb.append("L");
    else if (n.right != null && find(n.right, val, sb))
        sb.append("R");
    return sb.length() > 0;
}
public String getDirections(TreeNode root, int startValue, int destValue) {
    StringBuilder s = new StringBuilder(), d = new StringBuilder();
    find(root, startValue, s);
    find(root, destValue, d);
    int i = 0, max_i = Math.min(d.length(), s.length());
    while (i < max_i && s.charAt(s.length() - i - 1) == d.charAt(d.length() - i - 1))
        ++i;
    return "U".repeat(s.length() - i) + d.reverse().toString().substring(i);
}
```

# LCA

- step 1: find lca
- step 2: start from lca, find the two nodes, build the path at the same time
- step 3: build the overall path

```java
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode node = getLCA(root, startValue, destValue);
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        findStart(node, startValue, sb1);
        findDest(node, destValue, sb2);
        
        return sb1.toString() + sb2.reverse().toString();
    }

    private boolean findStart(TreeNode node, int value, StringBuilder sb) {
        if (node == null) {
            return false;
        }

        if (node.val == value) {
            return true;
        } 
        
        boolean left = findStart(node.left, value, sb);
        boolean right = findStart(node.right, value, sb);

        if (left || right) {
            sb.append("U");
        }
        
        return left || right;
    }

    private boolean findDest(TreeNode node, int value, StringBuilder sb) {
        if (node == null) {
            return false;
        }

        if (node.val == value) {
            return true;
        } 
        
        boolean left = findDest(node.left, value, sb);
        boolean right = findDest(node.right, value, sb);
        
        if (left) {
            sb.append("L");
        } else if (right) {
            sb.append("R");
        }
        
        return left || right;
    }
    
    
    private TreeNode getLCA(TreeNode root, int one, int two) {
        if (root == null || root.val == one || root.val == two) {
            return root;
        }
        
        TreeNode left = getLCA(root.left, one, two);
        TreeNode right = getLCA(root.right, one, two);
        
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
```

