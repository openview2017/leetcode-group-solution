"""
Using monotonic stack.
[m,x,x,a,x,x,n] assume a is smaller than x and a > m and a > n.
The number of subarrays that a is the minimum should equal to: num_of_occurances = (index(a)-index(m))*(index(n)-index(a))

Suppose there are p numbers to the left of a including a, q numbers to the right of a including a.
num_of_occurances = (p-1)*(q-1) + (p-1)*1 + (q-1)*1 +1

Time complexity: O(N)
Space complexity: O(N)
"""
from typing import List
import sys

class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        stack = []
        result = 0
        for i in range(len(arr)+1):
            cur = arr[i] if i < len(arr) else -sys.maxsize
            while stack and arr[stack[-1]] > cur:
                mid = stack.pop()
                left = stack[-1] if stack else -1
                right = i
                result = (result + arr[mid] * (mid-left) * (right-mid)) % (10**9 + 7)
            stack.append(i)
        return result