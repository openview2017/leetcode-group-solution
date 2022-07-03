from typing import List


class Solution0055:
    # Method 1: DP, tc: o(n2), sc: O(n)
    def canJump0(self, nums: List[int]) -> bool:
        n = len(nums)
        dp = [False]*(n)
        dp[0] = True
        for i in range(1, n):   
            for j in range(0, i):
                if dp[j] and j + nums[j] >= i:
                    dp[i] = True
                    break          
        return dp[n-1]
    # Method 2: Greedy/BFS, tc: o(n), sc: O(1)
    def canJump(self, nums: List[int]) -> bool:
        cur, farthest = 0, 0
        n = len(nums)
        for i in range(n):
            if i > cur:
                return False
            farthest = max(farthest, i + nums[i])
            if i == cur:
                cur = farthest
        return True