import heapq
import sys
from typing import List
"""
Using Dijkstra's algorithm. Greedy algorithm
Time complexity: O(N)
Space complexity: O(N**2)
"""
class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        closest = [(grid[0][0], 0, 0)] # Heap used to hold candidates and to provide the next smallest height grid.
        picked = dict() # The grids that were already chosen
        visited = {(0,0)} # The grids that were already added to candidates heap
        directions = [(0,1), (1,0), (0,-1), (-1,0)]
        while closest:
            cur = heapq.heappop(closest)
            val, row, col = cur
            picked[(row, col)] = val # This grid is chosen.
            if row == len(grid)-1 and col == len(grid[0])-1:
                return val
            
            # Find curent gird's neighbors and add to the candidate heap
            for i, j in directions:
                if 0 <= row + i < len(grid) and 0 <= col + j < len(grid[0]) and (row+i, col+j) not in picked and (row+i, col+j) not in visited:
                    min_neighbor = sys.maxsize
                    # Find all chosen neighbors and update current height with their height.
                    for m, n in directions:
                        if (row+i+m, col+j+n) in picked:
                            min_neighbor = min(min_neighbor, picked[(row+i+m, col+j+n)])
                    optimal = max(grid[row+i][col+j], min_neighbor)
                    # Add current optimal to candidate heap
                    heapq.heappush(closest, (optimal, row+i, col+j))
                    visited.add((row+i, col+j)) # Already added to heap, thus will not be added again.
        return
        
        
        