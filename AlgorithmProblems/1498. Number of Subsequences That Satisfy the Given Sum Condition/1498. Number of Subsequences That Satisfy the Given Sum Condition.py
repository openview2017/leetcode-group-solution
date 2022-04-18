"""
Use binary search and math calculation.
TC: O(NlogN)
SC: O(1)
"""
from typing import List
class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        nums = sorted(nums)
        result = 0
        for low in range(len(nums)):
            target_index = self.binary_search(nums, target-nums[low])
            if target_index < low:
                break
            result += 1 << (target_index - low)
        return result  % (10**9 + 7)
        
    def binary_search(self, nums, target):
        left, right = 0, len(nums)-1
        while left + 1 < right:
            mid = (right-left) // 2 + left
            if nums[mid] > target:
                right = mid
            else:
                left = mid
        if nums[right] <= target:
            return right
        elif nums[left] <= target:
            return left
        else:
            return -1