from typing import List
"""
Time complexity: O(N)
Space complexity: O(1)
Starting from lower-1 to upper+1. 
If we find single missing number, directly append. 
If we found multiple missing numbers, format the string then append to result.
"""
class Solution:
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[str]:
        result = []
        for i in range(len(nums)+1):
            r = nums[i] if i < len(nums) else upper + 1
            l = nums[i-1] if i > 0 else lower - 1
            if r - l == 2:
                result.append(str(r-1))
            elif r - l > 2:
                result.append("{left}->{right}".format(left = l+1, right = r-1))
        return result