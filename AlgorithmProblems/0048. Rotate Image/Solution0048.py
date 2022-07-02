# https://www.lintcode.com/problem/161/solution/57154

from typing import List

from numpy import matrix


class Solution0048:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix[0])
        for i in range(n//2):
            for j in range((n+1)//2):
                matrix[i][j],matrix[n-1-j][i],matrix[n-1-i][n-1-j],matrix[j][n-1-i] \
                = matrix[n-1-j][i], matrix[n-1-i][n-1-j],matrix[j][n-1-i],matrix[i][j]
                
sol = Solution0048()
matrix = [[1,2,3],[4,5,6],[7,8,9]]
print(matrix)
sol.rotate(matrix)
print(matrix)
