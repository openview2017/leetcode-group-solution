"""
BFS. Iterate through each building and calculate the distance to every empty land with BFS. 
TC: O(M^2*N^2)
SC: O(M*N)
"""
from typing import List
from collections import deque
import sys
class Solution:
    def shortestDistance(self, grid: List[List[int]]) -> int:
        num_of_buildings = 0
        min_dist = sys.maxsize
        distance = [[[0, 0] for i in range(len(grid[0]))] for j in range(len(grid))]  # distance to track the distance to each building and num of buildings the empty land can reach.
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] != 1:
                    continue
                self.bfs(grid, distance, i, j)
                num_of_buildings += 1
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0 and distance[i][j][1] == num_of_buildings:  # Only update when the empty spot can reach all buildings.
                    min_dist = min(min_dist, distance[i][j][0])
        return min_dist if min_dist != sys.maxsize else -1
    
    def bfs(self, grid, distance, row, col):
        visited = [[False for i in range(len(grid[0]))] for j in range(len(grid))]
        queue = deque([(row, col)])
        visited[row][col] = True
        step = 0
        while queue:
            l = len(queue)
            for i in range(l):
                cur_row, cur_col = queue.popleft()
                distance[cur_row][cur_col][0] += step
                distance[cur_row][cur_col][1] += 1
                for i, j in [(1, 0), (0, 1), (-1, 0), (0, -1)]:
                    new_row, new_col = cur_row+i, cur_col+j
                    if 0 <= new_row < len(grid) and 0 <= new_col < len(grid[0]) and grid[new_row][new_col] == 0 and not visited[new_row][new_col]:
                        queue.append((new_row, new_col))
                        visited[new_row][new_col] = True
            step += 1
        return

"""
BFS. Iterate through each empty land and calculate the sum distance to every building with BFS. 
This will have time limit exceed error.
TC: O(M^2*N^2)
SC: O(M*N)
"""
class Solution:
    def shortestDistance(self, grid: List[List[int]]) -> int:
        num_of_buildings = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    num_of_buildings += 1
        min_dist = sys.maxsize
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] != 0:
                    continue
                min_dist = min(min_dist, self.bfs(grid, num_of_buildings, i, j))
        return min_dist if min_dist != sys.maxsize else -1
    
    def bfs(self, grid, num_of_buildings, row, col):
        visited = [[False for i in range(len(grid[0]))] for j in range(len(grid))]
        queue = deque([(row, col)])
        visited[row][col] = True
        step = 0
        distance = 0
        while queue:
            step += 1
            l = len(queue)
            for i in range(l):
                cur_row, cur_col = queue.popleft()

                for i, j in [(1, 0), (0, 1), (-1, 0), (0, -1)]:
                    new_row, new_col = cur_row+i, cur_col+j
                    if 0 <= new_row < len(grid) and 0 <= new_col < len(grid[0]):
                        if grid[new_row][new_col] == 0 and not visited[new_row][new_col]:
                            queue.append((new_row, new_col))
                        elif grid[new_row][new_col] == 1 and not visited[new_row][new_col]:
                            distance += step
                            num_of_buildings -= 1
                        visited[new_row][new_col] = True
            
        return distance if num_of_buildings == 0 else sys.maxsize