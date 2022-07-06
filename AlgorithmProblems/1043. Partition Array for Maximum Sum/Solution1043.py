from typing import List


class Solution1043:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0 for _ in range(n+1)]
        for i in range(1,n+1): # len of subarray
            maxval, temp = 0, 0
            for j  in range(1,k+1):
                if i - j >= 0:
                    maxval = max(maxval, arr[i-j])
                    temp = max(temp, maxval * j + dp[i-j])
            dp[i] = temp
        return dp[n]


sol = Solution1043()

arr = [1,15,7,9,2,5,10]
k = 3
res = sol.maxSumAfterPartitioning(arr, k)
print(res)

arr = [1,4,1,5,7,3,6,1,9,9,3]
k = 4
res = sol.maxSumAfterPartitioning(arr, k)
print(res)

arr =  [1]
k = 1
res = sol.maxSumAfterPartitioning(arr, k)
print(res)