from typing import List


class Solution0053:
    def maxSubArray(self, nums: List[int]) -> int:
        glbmax, cur = float("-inf"), 0
        n = len(nums)
        for i in range(n):
            if cur < 0:
                cur = nums[i]
            else:
                cur += nums[i]
            glbmax = max(glbmax, cur)
        return glbmax
  
    # Kadane's Algorithm
    def maxSubArray(self, nums: List[int]) -> int:
        # Initialize our variables using the first element.
        current_subarray = max_subarray = nums[0]
        
        # Start with the 2nd element since we already used the first one.
        for num in nums[1:]:
            # If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            current_subarray = max(num, current_subarray + num)
            max_subarray = max(max_subarray, current_subarray)
        
        return max_subarray