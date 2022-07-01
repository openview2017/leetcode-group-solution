"""
Using monotonic stack.
The solution is using the solution of problem 907.Sum of Subarray Minimums.
Time complexity: O(N)
Space complexity: O(N)
"""

import sys
from typing import List
class Solution:
    def subArrayRanges(self, nums: List[int]) -> int:
        return self.sumSubarrayMaxs(nums) - self.sumSubarrayMins(nums)
    
    def sumSubarrayMins(self, arr: List[int]) -> int:
        stack = []
        result = 0
        for i in range(len(arr)+1):
            cur = arr[i] if i < len(arr) else -sys.maxsize
            while stack and arr[stack[-1]] > cur:
                mid = stack.pop()
                left = stack[-1] if stack else -1
                right = i
                result += arr[mid] * (mid-left) * (right-mid)
            stack.append(i)
        return result
    
    def sumSubarrayMaxs(self, arr: List[int]) -> int:
        stack = []
        result = 0
        for i in range(len(arr)+1):
            cur = arr[i] if i < len(arr) else sys.maxsize
            while stack and arr[stack[-1]] < cur:
                mid = stack.pop()
                left = stack[-1] if stack else -1
                right = i
                result += arr[mid] * (mid-left) * (right-mid)
            stack.append(i)
        return result
    