from typing import List


class Solution360:
    def sortTransformedArray(self, nums: List[int], a: int, b: int, c: int) -> List[int]:
        def quadratic(x):
            return a*x*x + b*x + c
        n = len(nums)
        if a < 0:
            idx = 0
        else:
            idx = n - 1

        l, r, ans = 0, n-1, [0]*n

        while l <= r:
            l_val, r_val = quadratic(nums[l]), quadratic(nums[r])
            if a >= 0:
                if l_val > r_val:
                    ans[idx] = l_val
                    l += 1
                else:
                    ans[idx] = r_val
                    r -= 1
                idx -= 1
            else:
                if l_val > r_val:
                    ans[idx] = r_val
                    r -= 1
                else:
                    ans[idx] = l_val
                    l += 1
                idx += 1                
        return ans

sol = Solution360()
nums = [-4,-2,2,4]
a = 1 
b = 3 
c = 5
res = sol.sortTransformedArray(nums,a,b,c)
print(nums)
print(res)