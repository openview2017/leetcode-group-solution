from typing import List


class Solution0300:
    def lengthOfLIS0(self, nums: List[int]) -> int:
        dp = [1 for _ in range(len(nums))]
        maxlen = 0
        for i in range(len(nums)):
          for j in range(i):
            if nums[j] < nums[i] and dp[i] < dp[j] + 1:
              dp[i] = dp[j] + 1
          maxlen = max(maxlen, dp[i])
        
        return maxlen   
    
    def lengthOfLIS(self, nums: List[int]) -> int:
        minend = [0 for _ in range(len(nums))]
        maxlen = 0
        for num in nums:
            left, right, mid = 0, maxlen, 0
            while left < right:
                mid = left + (right - left) // 2
                if minend[mid] >= num:
                    right = mid
                else:
                    left = mid + 1
            minend[left] = num
            if left == maxlen:
                maxlen += 1
        # print(minend)
        return maxlen  