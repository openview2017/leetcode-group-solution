# This solution is taking from the leetcode queston 1567. Maximum Length of Subarray With Positive Product
from typing import List
"""
The result subarray must either start from the first element or the last element.
Therefore, we can scan from left and from right to find the longest subarray whose product is positive and return the length.

Using N to denote negative numbers, and P to denode positeve numbers.
For array without 0 cases:
111111
(N) means the product of the middle part of the array is Negative. (P) is for positive
    1. N(N)N || P(N)P => Result subarray starting from both left and right.
    2. N(N)P || P(P)N => Result subarray starting from left.
    3. P(N)N || N(P)P => Result subarray starting from Right.
    4. P(P)P => Result subarray starting either from left or from right.
If array contains 0, then we should split the input array by the 0 elements and calculate each part individually because the result subarray couldn't contain 0s.

Time complexity: O(N)
Space complexity: O(1) If we do not reverse the array nums, but use 2 loops instead. 
"""
class Solution:
    def getMaxLen(self, nums: List[int]) -> int:
        return max(self.getOneSideMaxLen(nums), self.getOneSideMaxLen(nums[::-1]))
    
    def getOneSideMaxLen(self, nums):
        max_len = 0
        cur_len = 0
        cur_product = 1
        for i in range(len(nums)):
            # When we meet with 0s, we need to restart scanning and reset the cur_len and cur_product.
            if nums[i] == 0:
                cur_len = 0
                cur_product = 1
                continue
            cur_len += 1
            cur_product *= self.sign(nums[i])
            # Update max_len when current product is positive.
            if cur_product > 0:
                max_len = max(cur_len, max_len)
        return max_len
    
    # Function to get the sign for current integer.
    # With this, we can avoid calculating big integers product to make the program faster.
    def sign(self, integer):
        if integer >= 0:
            return 1
        return -1
