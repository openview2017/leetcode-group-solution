from typing import List
"""
Using slow and quick pointer. Each time if quick pointer is not target value, overwrite slow pointer with quick pointer's elements. Move slow forward after swap.
Time complexity: O(N)
Space complexity: O(1)
"""
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        cur = 0
        for i in range(len(nums)):
            if nums[i] != val:
                nums[cur] = nums[i]
                cur += 1
        return cur
"""
Using slow and quick pointer. Each time if quick pointer is not target value, swap slow pointer and quick pointer's elements. Move slow forward after swap.
Time complexity: O(N)
Space complexity: O(1)
"""
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        if not nums:
            return 0
        l = 0
        r = 0
        while l < len(nums) and r < len(nums):
            if nums[l] != val:
                l += 1
                continue
            if r <= l or nums[r] == val:
                r += 1
                continue
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r += 1
        return l

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