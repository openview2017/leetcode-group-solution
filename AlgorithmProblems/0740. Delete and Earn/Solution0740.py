from typing import List


class Solution0740:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_num = max(nums)
        sums = [0]* (max_num + 1)
        for num in nums:
            sums[num] += num 
        dp = [0]* (max_num + 1)
        
        dp[1] += sums[1]
        
        for i in range(2, max_num + 1):
            dp[i] = max(dp[i-2] + sums[i], dp[i-1])
        
        return dp[max_num]