
"""
Use dynamic programming to solve. 
For each house, we have 2 choices, rob or not rob:
    1. Rob: (Last house can not be robbed. We can only pick the not robbed value from last house adding current house value.)
        dp[cur][rob] = dp[cur-1][not_rob] + nums[cur]
    2. Not rob: (Last house can either be robbed or not robbed. We will pick the larger value one.)
        dp[cur][not_rob] = dp[cur-1][rob], dp[cur-1][not_rob]
TC: O(N)
SC: O(N)
"""
from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [[0, 0] for i in range(len(nums)+1)]
        for i in range(len(nums)):
            dp[i+1][0] = dp[i][1] + nums[i]
            dp[i+1][1] = max(dp[i][0], dp[i][1])
        return max(dp[i+1][0], dp[i+1][1])