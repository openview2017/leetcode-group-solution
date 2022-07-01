from typing import List


class Solution0169:
    def majorityElement(self, nums: List[int]) -> int:
        count = 0
        candidate = None
        
        for num in nums:
            if count == 0:
                candidate = num
            count += (1 if num == candidate else -1)
        
        return candidate

sol = Solution0169()
nums = [3,2,3]
print(nums)
maj = sol.majorityElement(nums)
print(maj)

# voting algorithm, tc: o(n), sc: o(1)