from typing import List


class Solution1049:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        tot_sum = sum(stones)
        set_sum = tot_sum // 2
        dp = [0 for _ in range(set_sum+1)]
        
        
        for stone in stones: 
            for i in range(set_sum, stone - 1, -1):
                dp[i] = max(dp[i], dp[i-stone] + stone)
        
        return tot_sum - dp[set_sum] * 2