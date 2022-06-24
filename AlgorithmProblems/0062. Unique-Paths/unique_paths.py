"""
BFS 
"""
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
      
        DIRECTION = [[0, 1], [1, 0]]
        queue = collections.deque([(0, 0)])      
        res = 0
        
        while queue:
            x, y = queue.popleft()
            if x == m - 1 and y == n - 1:
                res += 1
            for dx, dy in DIRECTION:
                nx, ny = x + dx, y + dy
                
                if nx < m and ny < n:
                    queue.append((nx, ny))
        return res
"""
DFS
"""
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
      
        DIRECTION = [[0, 1], [1, 0]]
        self.res = 0
        self.dfs(m, n, 0, 0, DIRECTION)
        
        return self.res
    
    def dfs(self, m, n, x, y, DIRECTION):
        
        if x == m - 1 and y == n - 1:
            self.res += 1
        for dx, dy in DIRECTION:
            if dx + x < m and dy + y < n:
                self.dfs(m, n, dx + x, dy + y, DIRECTION)
"""
DP: space 2D
d[x][y] = d[x - 1][y] + d[x][y - 1]

"""
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        d = [[0] * n] * m
            
        for x in range(0, m):
            for y in range(0, n):
                if x == 0:
                    d[x][y] = 1
                elif y == 0:
                    d[x][y] = 1
                else:
                    d[x][y] = d[x - 1][y] + d[x][y - 1]                
        return d[-1][-1]
"""
DP: space 1D
"""
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        d = [1] + [0] * (n - 1)
            
        for x in range(0, m):
            for y in range(1, n):
                d[y] += d[y - 1]
        return d[-1]
