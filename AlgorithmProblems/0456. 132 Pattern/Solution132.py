from typing import List


class Solution0456: 
    def find132pattern(self, nums: List[int]) -> bool:
        pollMax = float('-inf')
        stack = []
        for n in nums[::-1]:
            if n < pollMax:
                return True
            while stack and n > stack[-1]:
                pollMax = max(pollMax, stack.pop())
            stack.append(n)
        return False

sol = Solution0456()
nums = [1,2,3,4]
res = sol.find132pattern(nums)
print(res)
