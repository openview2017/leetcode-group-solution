import sys
from typing import List
"""
Time complexity: O(N*logN) => sort O(N) => iterate
Space complexity: O(1)
"""
class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals = sorted(intervals)
        cur = -sys.maxsize
        count = 0
        for i, j in intervals:
            if i < cur:
                count += 1
                cur = min(cur, j)
            else:
                cur = j
        return count
        