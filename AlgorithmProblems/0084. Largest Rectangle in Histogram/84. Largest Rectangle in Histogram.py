"""
Using monotonic increasing stack. 
TC: O(N)
SC: O(N)
"""

from typing import List
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        heights.append(0)
        max_size = 0
        stack = [(0, -1)]
        for i in range(len(heights)):
            while heights[i] < stack[-1][0]:
                cur = stack.pop()
                max_size = max(max_size, (i-stack[-1][1]-1) * cur[0])
            stack.append((heights[i], i))
        return max_size