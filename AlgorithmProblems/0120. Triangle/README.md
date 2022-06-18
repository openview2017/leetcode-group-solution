# 120. Triangle

[Triangle - LeetCode](https://leetcode.com/problems/triangle/)；Same as LintCode 109

> 本题是一道非常经典且历史悠久的动态规划题，其作为算法题出现，最早可以追溯到 1994 年的 IOI（国际信息学奥林匹克竞赛）的 [The Triangle](https://ioinformatics.org/files/ioi1994problem1.pdf)。时光荏苒，经过 20 多年的沉淀，往日的国际竞赛题如今已经变成了动态规划的入门必做题，不断督促着我们学习和巩固算法。

- 一个数字三角形，找到从顶部到底部的最小路径和。
- 每一步可以移动到下面一行的相邻数字上。
- 对每个元素 `(x, y)`，可以向正下方 `(x + 1, y)` 和右下方 `(x + 1, y + 1)` 走
- 输出：min path sum

```python
triangle = [
     [2],
     [3,4],
     [6,5,7],
     [4,1,8,3]
]
output: 2 + 3 + 5 + 1 = 11
```

与二叉树比较：

- n 层数字三角形，有 $n ^ 2$  个节点

  $1 + 2 + 3 + ... + n = \frac{ n(n+1)}{2}$

- n 层 complete binary tree，有 $2 ^ n$ 个节点

  $1 + 2 + 4 + ... + 2^{n-1} = 2^n$

## DFS

*Time Limit Exceeded, 42 / 44 test cases passed.*

Complexity Analysis:

- Time Complexity: $O(2 ^n)$
  - n 层，每层俩叉
- Space Complexity: O(n)

```python
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        result = [float("inf")]
        self.dfs(triangle, 0, 0, 0, result)
        return result[0]
    
    def dfs(self, triangle, x, y, path_sum, result):
        if x == len(triangle):
            result[0] = min(result[0], path_sum)
            return
        
        self.dfs(triangle, x + 1, y, path_sum + triangle[x][y], result)
        self.dfs(triangle, x + 1, y + 1, path_sum + triangle[x][y], result)
```

## Recursion - Divide & Conquer

*Time Limit Exceeded, 42 / 44 test cases passed.*

- Time Complexity: $O(2 ^n)$
  - n 层，每层俩叉
- Space Complexity: O(n)

```python
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        return self.recursion(triangle, 0, 0)
    
    def recursion(self, triangle, x, y):
        if x == len(triangle):            
            return 0
        
        left = self.recursion(triangle, x + 1, y)
        right = self.recursion(triangle, x + 1, y + 1)
        
        return min(left, right) + triangle[x][y]
```

## Recursion -  Optimzed  (Memoization Search)

*LeetCode Accepted*

有重复计算，每两个小三角形中，有一次重复计算

- Time Complexity: $O(n^2)$
  - $O( \frac{ n(n+1)}{2} \cdot 2 )$

```python
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        return self.recursion(triangle, 0, 0, {})
    
    def recursion(self, triangle, x, y, memo):
        if x == len(triangle):            
            return 0
        
        if (x, y) in memo:
            return memo[(x, y)]
        
        left = self.recursion(triangle, x + 1, y, memo)
        right = self.recursion(triangle, x + 1, y + 1, memo)
        
        memo[(x, y)] = min(left, right) + triangle[x][y]
        return memo[(x, y)]
```

记忆化搜索：要求函数有返回值（给一个参数，返回一个结果）且无副作用

## DP - Bottom Up

- Time Complexity: $O(n^2)$
- Space Complexity: $O(n^2)$

```python
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        
        # dp[i][j] 表示：从 i，j 走到最底层的最小 path sum
       
        dp = [[0] * (i + 1) for i in range(n)]  # [ [0],[0,0],[0,0,0] ]
        
        
        # initialization, 最底层行
        for i in range(n):
            dp[n-1][i] = triangle[n-1][i]
        
         
        for i in range(n - 2, -1, -1):
            for j in range(i + 1):
                dp[i][j] = min(dp[i+1][j], dp[i+1][j+1] ) + triangle[i][j]
        
        return dp[0][0]
```

## DP - Top Down

- Time Complexity: $O(n^2)$
- Space Complexity: $O(n^2)$

```python
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        
        # dp[i][j] 表示：从 0,0 走到 i，j 的最小 sum path       
        dp = [[0] * (i + 1) for i in range(n)]  # [ [0],[0,0],[0,0,0] ]
        
        
        # initialization, 三角形的左边和右边
        """
         triangle     dp
         [0],         [0],
         [0,4],       [0,4],
         [6,5,7],     [6,0,11],
         [4,1,8,3]    [10,0,0,14]

        """
        dp[0][0] = triangle[0][0]
        for i in range(1, n):
            dp[i][0] = dp[i-1][0] + triangle[i][0]      # DP 三角形的左边
            dp[i][i] = dp[i-1][i-1] + triangle[i][i]    # DP 三角形的右边
        
         
        for i in range(2, n):
            for j in range(1, i):
                dp[i][j] = min(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j]
        
        # 最后一层任意的位置都可能是 min sum path 的终点
        return min(dp[n-1])
```