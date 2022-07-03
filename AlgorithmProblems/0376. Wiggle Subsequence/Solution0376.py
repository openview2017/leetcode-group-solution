from typing import List


class Solution0376:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return len(nums)
        up, down = 1, 1
        for i in range(1, len(nums)):
            if nums[i] > nums[i-1]:
                up = max(up, down + 1)
                down = 1
            elif nums[i] < nums[i-1]:
                down = max(down, up + 1)
                up = 1
        
        return max(up, down)

sol = Solution0376()
nums = [1,7,4,9,2,5]
res = sol.wiggleMaxLength(nums)
print(res)