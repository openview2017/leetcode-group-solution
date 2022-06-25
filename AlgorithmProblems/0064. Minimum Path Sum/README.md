# **64. Minimum Path Sum**

- 输入: m * n 矩阵，无负数
- 寻找从左上到右下，只能向右或向下走，最小的 path sum

```
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
```

![Untitled](https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg)

------

## DP Top-down

- State: 
  - `dp[i][j]`: 从 (0,0) 开始，到达 (i, j) 的最小 path sum
- Initialization: 
  - `dp[0][0] = grid[0][0]`
- Induction Rule:
  1. 如果当前位置只能通过「向下」移动而来：`dp[i][j] = dp[i-1][j] + grid[i][j]`
  2. 如果当前位置只能通过「向右」移动而来：`dp[i][j] = dp[i][j-1] + grid[i][j]`
  3. 如果当前位置既能通过「向下」也能「向右」移动而来：`dp[i][j] = min(dp[i][j-1],dp[i-1][j]) + grid[i][j]`

- Complexity Analysis:

  - Time Complexity: $O(m*n)$

  - Space Complexity: $O(m*n)$

Python

```python
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dp = [[0] * n for _ in range(m)]
        
        
        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    dp[i][j] = grid[i][j]            
                else:
                    top = dp[i - 1][j] + grid[i][j] if i - 1 >= 0 else float("inf")
                    left = dp[i][j - 1] + grid[i][j] if (j - 1 >= 0) else float("inf")   
                    dp[i][j] = min(top, left)
        
              
        return dp[m - 1][n - 1]
```

Java

```java
class Solution {
    public int minPathSum(int[][] grid) {        
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int top  = i - 1 >= 0 ? dp[i - 1][j] + grid[i][j] : Integer.MAX_VALUE;
                    int left = j - 1 >= 0 ? dp[i][j - 1] + grid[i][j] : Integer.MAX_VALUE;
                    dp[i][j] = Math.min(top, left);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
```

## DP Bottom-Up

- State:
  - `dp[i][j]` : 从 (m-1,n-1) 到 (0,0) 的最短路径
- 移动方向：向上、向左

```java
class Solution {
    public int minPathSum(int[][] grid) {        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = grid[i][j];
                } else {
                    int bottom = i + 1 < m ? dp[i + 1][j] + grid[i][j] : Integer.MAX_VALUE;
                    int right  = j + 1 < n ? dp[i][j + 1] + grid[i][j] : Integer.MAX_VALUE; 
                    dp[i][j] = Math.min(bottom, right);
                }
            }
        }

        return dp[0][0];
    }

}
```

## Follow-Up

<aside> 💡 如果要输出总和最低的路径呢？（如果有多个答案，返回其中之一即可） </aside>

基于 bottom - up ：

Java

```java
class Solution {
    int m, n;
    public int minPathSum(int[][] grid) {        
        m = grid.length;
        n = grid[0].length;
        int[][] f = new int[m][n];
        int[] g = new int[m * n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    f[i][j] = grid[i][j];
                } else {
                    int bottom = i + 1 < m ? f[i + 1][j] + grid[i][j] : Integer.MAX_VALUE;
                    int right  = j + 1 < n ? f[i][j + 1] + grid[i][j] : Integer.MAX_VALUE; 
                    f[i][j] = Math.min(bottom, right);
                    g[getIdx(i, j)] = bottom < right ? getIdx(i + 1, j) : getIdx(i, j + 1);
                }
            }
        }

        int idx = getIdx(0,0);
        for (int i = 1; i <= m + n; i++) {
            if (i == m + n) continue;
            int x = parseIdx(idx)[0], y = parseIdx(idx)[1];
            System.out.print("(" + x + "," + y + ") ");
            idx = g[idx];
        }
        System.out.println(" ");

        return f[0][0];
    }
    int[] parseIdx(int idx) {
        return new int[]{idx / n, idx % n};
    }
    int getIdx(int x, int y) {
        return x * n + y;
    }
}
```



## Ref

- [【动态规划 / 路径问题】进阶「最小路径和」问题 ... (qq.com)](https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247485106&idx=1&sn=39adbde98707dc02a99e71f58cad5e7c&scene=21#wechat_redirect)
