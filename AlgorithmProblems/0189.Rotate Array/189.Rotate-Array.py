from typing import List
"""
Rotate array equals to flip array 3 times.
First time, flip the whole array.
Second time, flip the left part all the way to length k.
Third time, flip the remaining right part.
Time complexity: O(N)
Space complexity: O(1)
"""
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if k == 0:
            return
        else:
            k = k % len(nums) # if k is greater than length of array.
        self.flip(nums, 0, len(nums)-1)
        self.flip(nums,0, k-1)
        self.flip(nums, k, len(nums)-1)
        return
        
    def flip(self, nums, l, r):
        if l > r or l < 0 or r > len(nums)-1:
            return
        while l <= r:
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r -= 1
        return
        