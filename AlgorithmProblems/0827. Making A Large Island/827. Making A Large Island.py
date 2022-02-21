from typing import List
"""
TC: O(M*N)
SC: O(M*N)
"""
class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]:
            return 0
        # Memo keeps the root position of the current element.
        memo = [[(-1, -1) for i in range(len(grid[0]))] for j in range(len(grid))]
        # size_dict tracks the area of current root element.
        size_dict = dict()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] != 1 or memo[i][j] != (-1, -1):
                    continue
                size_dict[(i, j)] = self.dfs(grid, i, j, memo, (i, j)) # Update size_dict with dfs result
        
        # Iterate through each element.
        # If current is 1, update max_size.
        # If current is 0, look at surrounding up, down, left, right elements and sum those areas without duplicates. Then update max_size.
        max_size = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    max_size = max(max_size,  size_dict[memo[i][j]])
                    continue
                cur_size = 1
                visited = set()
                for r, c in [(1, 0), (0, 1), (-1, 0), (0, -1)]:
                    new_row, new_col = i + r, j + c
                    if 0 <= new_row < len(grid) and 0 <= new_col < len(grid[0]) and grid[new_row][new_col] == 1:
                        if memo[new_row][new_col] in visited:
                            continue
                        cur_size += size_dict[memo[new_row][new_col]]
                        visited.add(memo[new_row][new_col])
                max_size = max(max_size, cur_size)
        return max_size
    
    def dfs(self, grid, row, col, memo, root):
        memo[row][col] = root
        total_size = 1
        for i, j in [(1, 0), (0, 1), (-1, 0), (0, -1)]:
            new_row, new_col = row + i, col + j
            if 0 <= new_row < len(grid) and 0 <= new_col < len(grid[0]) and grid[new_row][new_col] and memo[new_row][new_col] == (-1, -1):
                total_size += self.dfs(grid, new_row, new_col, memo, root)
        return total_size
        
        