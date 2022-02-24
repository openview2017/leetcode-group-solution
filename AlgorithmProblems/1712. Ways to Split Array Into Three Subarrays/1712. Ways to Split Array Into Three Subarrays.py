"""
Use prefix sum and binary search.
TC: O(NlogN)
SC: O(N) => prefix sum
"""

from typing import List
class Solution:
    def waysToSplit(self, nums: List[int]) -> int:
        prefix_sum = [0 for i in range(len(nums)+1)]
        for i in range(len(nums)):
            prefix_sum[i+1] = nums[i] + prefix_sum[i]
        result = 0
        left = 1
        # left array sum is always smaller than 1/3 of the total sum of whole array.
        # end index of left array is always smaller than length-2. Otherwise we don't have space for mid and right array.
        while prefix_sum[left] <= prefix_sum[-1] // 3 and left < len(prefix_sum)-2:
            # Binary search to find the leftmost element larger than 2 times of prefix sum of left array.
            left_idx = self.binary_search_left(prefix_sum, left+1, len(prefix_sum)-2, 2*prefix_sum[left])
            # Binary search to find the right most element smaller than 1/2 of sum of left an right prefix sum.
            right_idx = self.binary_search_right(prefix_sum, left+1, len(prefix_sum)-2, (prefix_sum[left] + prefix_sum[-1]) // 2)
            # The mid array is from left_idx to right_idx inclusive. The number of mid arrays is right_idx - left_idx + 1
            if right_idx >= left_idx:
                result += right_idx - left_idx + 1
            left += 1
        return result % (10**9 + 7)
    
    def binary_search_left(self, nums, left, right, target):
        while left + 1 < right:
            mid = (left + right) // 2
            if nums[mid] >= target:
                right = mid
            else:
                left = mid
        if nums[left] >= target:
            return left
        if nums[right] >= target:
            return right
        return -1
    
    def binary_search_right(self, nums, left, right, target):
        while left + 1 < right:
            mid = (left + right) // 2
            if nums[mid] <= target:
                left = mid
            else:
                right = mid
        if nums[right] <= target:
            return right
        if nums[left] <= target:
            return left
        return -1
        