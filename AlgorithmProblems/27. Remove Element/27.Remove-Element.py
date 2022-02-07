from typing import List

"""
Using two pointers. Similar to quick sort. Swap left an right when left pointer on val and right pointer not.
Time complexity: O(N)
Space complexity: O(1)
"""
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        if not nums:
            return 0
        left = 0
        right = len(nums)-1
        while left < right:
            if nums[left] != val:
                left += 1
                continue
            if nums[right] == val:
                right -= 1
                continue
            nums[left], nums[right] = nums[right], nums[left]
        # Check if left element equals to value
        # If so, return length without current element. If not return length with current element.
        if nums[left] == val:
            return left
        return left+1