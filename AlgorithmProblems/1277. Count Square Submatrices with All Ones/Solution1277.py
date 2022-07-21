from typing import List


class Solution1277:
    def countSquares(self, matrix: List[List[int]]) -> int:
        sum = 0
        r, c = len(matrix), len(matrix[0])
        dp = [[0]*(c+1) for _ in range(r+1)]
        for i in range(r):
            for j in range(c):
                if matrix[i][j] == 0:
                    dp[i+1][j+1] = 0
                else:
                    dp[i+1][j+1] = min(dp[i][j+1], dp[i+1][j], dp[i][j]) + 1
                    sum += dp[i+1][j+1]
        return sum