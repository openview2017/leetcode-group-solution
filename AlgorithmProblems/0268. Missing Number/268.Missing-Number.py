from typing import List
"""
Solution 1:
array = [3 0 1]
index:   0 1 2
suppose we have 0, 1, 2, 3 in array
sum(0, 1, 2, 3) - sum(index) = missing number
"""

class Solution1:
    def missingNumber(self, nums: List[int]) -> int:
        return len(nums) * (len(nums)+1) // 2 - sum(nums)

"""
Solution 2:
array = [3 0 1]
index:   0 1 2
Iterate through all elements and swap them to the position they should be located at.
Find the one not matching it's index after all swaps.
"""
class Solution2:
    def missingNumber(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            while nums[i] != i and nums[i] < len(nums):
                cur = nums[i]
                nums[i], nums[cur] = nums[cur], nums[i]
        for i in range(len(nums)):
            if nums[i] != i:
                return i
        return len(nums)