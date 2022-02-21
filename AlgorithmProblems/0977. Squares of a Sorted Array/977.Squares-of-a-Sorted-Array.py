"""
Time complexity: O(N)
"""
from typing import List
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        nums_sq = [i**2 for i in nums]
        result = [0 for i in range(len(nums))]
        l, r = 0, len(nums_sq)-1
        while l <= r:
            if nums_sq[l]>= nums_sq[r]:
                result[r-l] = nums_sq[l]
                l += 1
            else:
                result[r-l] = nums_sq[r]
                r -= 1
        return result  