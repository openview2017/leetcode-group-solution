from typing import List


class Solution1099:
    def twoSumLessThanK(self, nums: List[int], k: int) -> int:
        nums.sort()
        i, j = 0, len(nums) - 1
        res = -1
        while i < j:
            sum = nums[i] + nums[j]
            if sum >= k:
                j -= 1
            else:
                res = max(res, sum)
                i += 1
        return res

sol = Solution1099()
nums = [34,23,1,24,75,33,54,8]
k = 60
res = sol.twoSumLessThanK(nums, k)
print(res)