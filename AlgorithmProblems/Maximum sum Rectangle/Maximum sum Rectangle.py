"""
https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1#
TC: O(N^2 * M)
SC: O(M * N)
"""

import sys
class Solution:
    def maximumSumRectangle(self,R,C,M):
        #code here
        row_prefix_sum = [[0 for i in range(C)] for j in range(R+1)]
        for i in range(1, R+1):
            for j in range(C):
                row_prefix_sum[i][j] = row_prefix_sum[i-1][j] + M[i-1][j]
        max_sum = -sys.maxsize
        for row_start in range(R):
            for row_end in range(row_start+1, R+1):
                cur_sum = 0
                for j in range(C):
                    cur_sum += row_prefix_sum[row_end][j] - row_prefix_sum[row_start][j]
                    max_sum = max(max_sum, cur_sum)
                    cur_sum = 0 if cur_sum < 0 else cur_sum
        return max_sum