from typing import List
from collections import deque
"""
Use BFS for 8 directions.
TC: O(M*N)
SC: O(1) in place
"""
class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if grid[0][0] != 0:
            return -1
        step = 0
        queue = deque([(0, 0)])
        grid[0][0] = 1
        while queue:
            queue_len = len(queue)
            step += 1
            for i in range(queue_len):
                row, col = queue.popleft()
                if row == len(grid)-1 and col == len(grid[0])-1:
                    return step
                for m, n in [(0, 1), (1, 0), (0, -1), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]:
                    new_row, new_col = row + m, col + n
                    if 0 <= new_row < len(grid) and 0 <= new_col < len(grid[0]) and grid[new_row][new_col] == 0:
                        queue.append((new_row, new_col))
                        grid[new_row][new_col] = 1
        return -1