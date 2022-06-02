# 257. Binary Tree Paths

[Binary Tree Paths - LeetCode](https://leetcode.com/problems/binary-tree-paths/)

返回 Binary Tree 中，所有的从 root 到 leaf 的 path，稍微需要做一点格式化

```
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
```

# DFS

Complexity Analysis:
- Time Complexity: $O(n^2)$
  - N 表示节点数目
  - 在 DFS 中每个节点会被访问一次且只会被访问一次  -  O(n)
  - 每一次会对 path 变量进行拷贝构造 -  O(n)
- Space Complexity:  $O(n^2)$
  - Worst Case：二叉树中每个节点只有一个孩子节点时，即二叉树为链状，
    - 递归的层数为 N
    - 每一层的 path 变量的空间总和为 $O \left( \sum _ { i = 1 } ^ { N } i \right) = O \left( N ^ { 2 } \right)$
  - Best Case: 平衡二叉树
    - 高度为 $ \log N$
    - 空间复杂度：$O(\log^2 n)$ 

```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        traverse(root, "", paths);
        return paths;
    }

    public void traverse(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder pathBuilder = new StringBuilder(path);
            pathBuilder.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathBuilder.toString());  // 把路径加入到答案中
            } else {
                pathBuilder.append("->");  // 当前节点不是叶子节点，继续递归遍历
                traverse(root.left, pathBuilder.toString(), paths);
                traverse(root.right, pathBuilder.toString(), paths);
            }
        }
    }
}
```

另一种 DFS 写法（思想基本一样）

```java
class Solution0257_resursion {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)  return res;
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, root);
        return res;
    }
    private void dfs(List<String> res, StringBuilder sb, TreeNode root) {
        if (root == null) return;
        
        int origSize = sb.length();
        sb.append(Integer.toString(root.val));
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
        }
        
        dfs(res, sb, root.left);
        dfs(res, sb, root.right);
        sb.delete(origSize, sb.length());
    }
}
```

# BFS

Complexity Analysis:
- Time Complexity: $O(n^2)$
- Space Complexity:  $O(n^2)$

```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if (root == null) {
            return paths;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<String> pathQueue = new LinkedList<String>();

        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll(); 
            String path = pathQueue.poll();

            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
                }
            }
        }
        return paths;
    }
}
```

