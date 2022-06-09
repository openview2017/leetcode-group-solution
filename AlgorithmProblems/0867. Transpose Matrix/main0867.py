from typing import List


class Solution0867:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        R, C = len(matrix), len(matrix[0])
        res = [[0 for _ in range(R)] for _ in range(C)]
        for r in range(R):
            for c in range(C):
                res[c][r] = matrix[r][c]
        return res

matrix = [[1,2,3],[4,5,6],[7,8,9]]
print(matrix)
sol = Solution0867()
res = sol.transpose(matrix)
print(res)
