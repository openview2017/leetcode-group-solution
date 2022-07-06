from typing import List


class Solution0416:
    def canPartition(self, nums: List[int]) -> bool:
        # find sum of array elements
        total_sum = sum(nums)

        # if total_sum is odd, it cannot be partitioned into equal sum subsets
        if total_sum % 2 != 0:
            return False
        subset_sum = total_sum // 2

        # construct a dp table of size (subset_sum + 1)
        dp = [False] * (subset_sum + 1)
        dp[0] = True
        for curr in nums:
            for j in range(subset_sum, curr - 1, -1):
                dp[j] = dp[j] or dp[j - curr]

        return dp[subset_sum]

sol = Solution0416()
nums = [1,5,11,5]
res = sol.canPartition(nums)
print(res)