"""
Solution similar to Dijkstra:
Time complexity: O(mn*log(mn)) Iterating through all elements. The number of elements in heap will not exceed mn.
Space complexity: O(mn)
"""

import heapq
import sys
from typing import List

class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        visited = [[False for i in range(len(heights[0]))] for j in range(len(heights))]
        diff = [[sys.maxsize for i in range(len(heights[0]))] for j in range(len(heights))]
        heap = [(0, 0, 0)]
        visited[0][0] = 0
        diff[0][0] = 0
        while heap:
            cur = heapq.heappop(heap)
            if visited[cur[1]][cur[2]]:
                continue
            visited[cur[1]][cur[2]] = True  # Element with minimum diff selected from heap will be marked as visited.
            for i, j in [(0, 1), (1, 0), (0, -1), (-1, 0)]: # Expend to next level.
                row, col = cur[1] + i, cur[2] + j
                if 0 <= row < len(heights) and 0 <= col < len(heights[0]) and not visited[row][col]:
                    # Calculate the current diff and compare with the diff in last round.
                    # Pick the maximum of the two as the current diff.
                    cur_diff = max(abs(heights[row][col] - heights[cur[1]][cur[2]]), diff[cur[1]][cur[2]])
                    # If we have a smaller diff, push it into heap and update the diff matrix.
                    if cur_diff < diff[row][col]:
                        diff[row][col] = cur_diff
                        heapq.heappush(heap, (cur_diff, row, col))
        return diff[-1][-1]
                    