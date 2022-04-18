from typing import List
"""
row + col = cur_level (cur_level start from 0 to len(mat)+len(mat[0])-1)
For single and even level, change the start element position and direction. Add result to list.

TC: O(M*N)
SC: O(1)
"""
class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        result = []
        if not mat or not mat[0]:
            return result
        row, col = 0, 0
        for i in range(len(mat)+len(mat[0])-1):
            if i % 2 == 0:
                (row, col) = (i, 0) if i < len(mat) else (len(mat) - 1, i - len(mat) + 1)
                while row >= 0 and col < len(mat[0]):
                    result.append(mat[row][col])
                    row -= 1
                    col += 1
            else:
                (row, col) = (0, i) if i < len(mat[0]) else (i - len(mat[0]) + 1, len(mat[0]) - 1)
                while col >= 0 and row < len(mat):
                    result.append(mat[row][col])
                    row += 1
                    col -= 1
        return result