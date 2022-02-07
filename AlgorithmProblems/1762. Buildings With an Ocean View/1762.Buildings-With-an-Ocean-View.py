"""
Using monotonic decreasing stack.
Time complexity: O(N)
Space complexity: O(1) not considering result.
"""
from typing import List

class Solution:
    def findBuildings(self, heights: List[int]) -> List[int]:
        mono_stack = []
        for i in range(len(heights)):
            while mono_stack and heights[i] >= heights[mono_stack[-1]]:
                mono_stack.pop()
            mono_stack.append(i)
        return mono_stack