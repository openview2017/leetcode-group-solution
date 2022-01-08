### https://leetcode.com/problems/binary-tree-maximum-path-sum/
### 124. Binary Tree Maximum Path Sum

```
path from any node to any node;
for each possible path, there must be a top node as root (single path, combined path)
so, for each node, we think of it as root, to see the possible path pass this root has max path sum
 max = Math.max(max, leftSinglePathSum + rightSinglePathSum + root.val)
        if leftSinglePathSum < 0, ignore
        if rightSinglePathSum < 0, ignore

So we will need a helper function to get a singlePathSum from root to any of node in single path

```