
#  LeetCode 113. Path Sum II

输入：`TreeNode` Binary Tree 的 root, `int` targetSum

输出：`List<List<Integer>>` 在 Binary Tree 中，所有的从 root 到 leaf 的 sum 等于 target 的 paths

# DFS

- DFS，枚举每一条从根节点到叶子节点的路径。
- 当达到一个叶子节点，且此时路径和恰为目标和时，就找到了一条满足条件的路径

时间复杂度：$O(N^2)$，其中 N 是树的节点数。

- 在最坏情况下，树的上半部分为链状，下半部分为完全二叉树，并且从根节点到每一个叶子节点的路径都符合题目要求。
- 此时，路径的数目为 O(N)，并且每一条路径的节点个数也为 O(N)，因此要将这些路径全部添加进答案中，时间复杂度为 $O(N^2)$。 
- Copy 为 O(n)

空间复杂度：O(N)，其中 N 是树的节点数。

- 空间复杂度主要取决于栈空间的开销，栈中的元素个数不会超过树的节点数。

Java

```java
class Solution {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    Deque<Integer> pathStack = new LinkedList<Integer>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return result;        
    }
    
    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        
        pathStack.offerLast(root.val);
        target -= root.val;
        
        if (root.left == null && root.right == null && target == 0) {
            result.add(new LinkedList<Integer>(pathStack));
        }
        
        dfs(root.left, target);
        dfs(root.right, target);
        pathStack.pollLast();
    }
}
```

Python

```Python
class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        result = list()
        path = list()
        
        def dfs(root: TreeNode, targetSum: int):
            if not root:
                return
            path.append(root.val)
            targetSum -= root.val
            if not root.left and not root.right and targetSum == 0:
                result.append(path[:])
            dfs(root.left, targetSum)
            dfs(root.right, targetSum)
            path.pop()
        
        dfs(root, targetSum)
        return result
```

# BFS

- BFS 遍历。当遍历到 leaf 时，如果此时路径和恰为 target 时，就把路径加到结果中。
- 为了节省空间，使用 HashMap 记录树中的每一个节点的父节点。每次找到一个满足条件的节点，我们就从该节点出发不断向父节点迭代，即可还原出从根节点到当前节点的路径。

```java

class Solution {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return result;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> sumQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        sumQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int temp = sumQueue.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (temp == targetSum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    nodeQueue.offer(node.left);
                    sumQueue.offer(temp);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    nodeQueue.offer(node.right);
                    sumQueue.offer(temp);
                }
            }
        }

        return result;
    }

    public void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<Integer>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        result.add(new LinkedList<Integer>(temp));
    }
}
```

