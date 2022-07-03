class Solution0198:
    def rob(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0
        elif len(nums) == 1:
            return nums[0]
    
        n = len(nums)
        dp = [0]*n
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, n):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        return dp[-1]