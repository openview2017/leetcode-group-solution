"""
Using prefix sum on each column. Then use rectangular histogram on each row with monotonic increasing stack.
TC: O(M*N)
SC: O(M*N)
"""
from typing import List
class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        height_rectangle = [[0 for i in range(len(matrix[0])+1)] for j in range(len(matrix)+1)]
        for i in range(1, len(height_rectangle)):
            for j in range(len(height_rectangle[0])-1):
                if matrix[i-1][j] == "0":
                    continue
                height_rectangle[i][j] = height_rectangle[i-1][j] + 1
        max_size = 0
        for i in range(1, len(height_rectangle)):
            cur_maxsize = self.getMaxsize(height_rectangle, i)
            max_size = max(max_size, cur_maxsize)
        return max_size
    
    def getMaxsize(self, matrix, index):
        max_size = matrix[index][0]
        stack = [(0, -1)]
        for i in range(len(matrix[index])):
            while matrix[index][i] < stack[-1][0]:
                cur = stack.pop()
                max_size = max(max_size, cur[0] * (i-stack[-1][1]-1))
            stack.append((matrix[index][i], i))
        return max_size