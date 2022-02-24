from typing import List
"""
For each row, record the current max number we can get from left to right (left_max) and from right to left(right_max)
The new max number we can get for the next row would be the max number from left_max and right_max at each position plus the current number in current row.
We iteratively go to each row and apply this logic.
The max number we can get would be the max number in the last row.
TC: O(N^2)
SC: O(N)
"""
class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        left_max = [0]*len(points[0])
        right_max = [0] *len(points[0])
        for i in range(len(points)):
            cur = [points[i][j] + max(left_max[j], right_max[j]) for j in range(len(points[0]))]
            for p in range(len(cur)):
                if p == 0:
                    left_max[p] = cur[p]
                else:
                    left_max[p] = max(cur[p], left_max[p-1]-1)
            for q in range(len(cur)-1, -1, -1):
                if q == len(cur)-1:
                    right_max[q] = cur[q]
                else:
                    right_max[q] = max(cur[q], right_max[q+1]-1)
        return max(cur)