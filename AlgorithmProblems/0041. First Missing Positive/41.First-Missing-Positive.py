"""
Swap the element to it's right position.
Time complexity: O(N)
Space complexity: O(1)
"""
from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            while 0 <= nums[i] < len(nums) and nums[i] != i+1 and nums[i] != nums[nums[i]-1]:
                cur = nums[i]
                nums[i], nums[cur-1] = nums[cur-1], nums[i]
        for i in range(len(nums)):
            if nums[i] != i+1:
                return i+1
        return i+2
                