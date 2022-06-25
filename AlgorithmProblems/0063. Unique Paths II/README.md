# **63. Unique Paths II**

[63. Unique Paths II - LeetCode](https://leetcode.com/problems/unique-paths-ii/)

See Also:

- [【动态规划 / 路径问题】强化 DP 分析方法练习题  -  宫水三叶的刷题日记](https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247485089&idx=1&sn=fd52fd088a5778c9ee101741d458605d&scene=21#wechat_redirect)

---
- 一个机器人位于一个 m x n 网格的左上角 
- 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
- 考虑网格中有障碍物，网格中的障碍物和空位置分别用 1 和 0 表示
- 从左上角到右下角将会有多少条不同的路径？

eg.

![](https://assets.leetcode.com/uploads/2020/11/04/robot1.jpg)

```
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
```

------

此题与 [**62. Unique Paths**](https://www.notion.so/62-Unique-Paths-011293c6f16d4a54b1e9e632e7caa49e) 基本一致，多了障碍物不影响我们的分析

## DP Top-down

State：`dp[i][j]` 是到达 (i, j) 的方案总数

Initialization：

- `dp[0][0] = 1`
- 对于 `grid[i][j]` 为 1 的格子，`dp[i][j] = 0`

Induction Rule：

- `dp[i][j] = dp[i-1][j]  +  dp[i][j-1]`             如果既能向下，又能向右
- `dp[i][j] = dp[i][j-1]`                                          如果只能向右
- `dp[i][j] = dp[i-1][j]`                                          如果只能向下

Return: `dp[m-1][n-1]`

Complexity Analysis:

- Time Complexity: $O(m*n)$

- Space Complexity: $O(m*n)$

Java

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    if (i > 0 && j > 0) {
                        f[i][j] = f[i - 1][j] + f[i][j - 1];
                    } else if (i > 0) {
                        f[i][j] = f[i - 1][j];
                    } else if (j > 0) {
                        f[i][j] = f[i][j - 1];
                    }
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
```

