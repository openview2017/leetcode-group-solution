# 2290. Minimum Obstacle Removal to Reach Corner

See also: **1293. Shortest Path in a Grid with Obstacles Elimination**

与 1293 类似， 1293 问最短距离是多少，此题问最少移除几个障碍物

- matrix，0 表示空地，1 表示障碍物。
- 问从左上走到右下，最少移除几个障碍物？

![Untitled](https://assets.leetcode.com/uploads/2022/04/06/example1drawio-1.png)

```python
输入：grid = [[0,1,1],[1,1,0],[1,1,0]]
输出：2
解释：可以移除位于 (0, 1) 和 (0, 2) 的障碍物来创建从 (0, 0) 到 (2, 2) 的路径。
可以证明我们至少需要移除两个障碍物，所以返回 2 。
注意，可能存在其他方式来移除 2 个障碍物，创建出可行的路径。
```

## 0-1 BFS

*Ziheng Gong - June 15 2022*

从起点出发到终点，障碍物的 cost 为 1，空地的 cost 为 0

遇到 0，加到队列头部；遇到 1，加到队列尾部

```python
class Solution:
    def minimumObstacles(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        distance = [[float("inf")] * n for _ in range(m)]
        distance[0][0] = 0
        queue = collections.deque()
        queue.appendleft((0, 0))
        while queue:
            x, y = queue.popleft()
            for nx, ny in (x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1):
                if 0 <= nx < m and 0 <= ny < n:
                    block = grid[x][y]
                    if distance[x][y] + block < distance[nx][ny]:
                        distance[nx][ny] = distance[x][y] + block
                        if block == 0: # 遇到 0 就添加到队列头
                            queue.appendleft((nx, ny))
                        else: 
                            queue.append((nx, ny))
        
        return distance[m - 1][n - 1]
```