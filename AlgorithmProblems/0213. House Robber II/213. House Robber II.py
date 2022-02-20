"""
Use dynamic programming to solve this problem.
Devide the cases into 2:
1. Rob the first house, then we only pick the result when we don't rob the last house.
2. Not rob the first house, then we pick the result either from we rob the last house or we don't.
The final result is the larger one among these three.
For example:
                [7,    4,    1,    9,    3,    8,    6]
rob_first rob   [7,  -max,   8,   16,   11,    24,   22]
      not rob   [-max, 7,    7,    8,   16,    16,   24] compare   pick
rob_first no_rob[-max, 4,    1,   13,    7,    21,   19] compare
      not rob   [0,    0,    4,    4,   13,    13,   21] compare   

TC: O(N)
SC: O(N)
"""

from typing import List
import sys
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return
        if len(nums) == 1:
            return nums[0]
        dp_rob = [[0,0] for i in range(len(nums))]
        dp_rob[0] = [nums[0], -sys.maxsize]
        dp_no_rob = [[0,0] for i in range(len(nums))]
        dp_no_rob[0] = [-sys.maxsize, 0]
        
        for i in range(1, len(nums)):
            dp_rob[i][0] = dp_rob[i-1][1] + nums[i]
            dp_rob[i][1] = max(dp_rob[i-1])
            dp_no_rob[i][0] = dp_no_rob[i-1][1] + nums[i]
            dp_no_rob[i][1] = max(dp_no_rob[i-1])
            
        return max(dp_rob[-1][1], dp_no_rob[-1][0], dp_no_rob[-1][1])