import heapq
from typing import List


class Solution0480:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        small, large = [], []
        for i, x in enumerate(nums[:k]): 
            heapq.heappush(small, (-x,i))
        for _ in range(k-(k>>1)): 
            self.move(small, large)
        ans = [self.get_med(small, large, k)]
        for i, x in enumerate(nums[k:]):
            if x >= large[0][0]:
                heapq.heappush(large, (x, i+k))
                if nums[i] <= large[0][0]: 
                    self.move(large, small)
            else:
                heapq.heappush(small, (-x, i+k))
                if nums[i] >= large[0][0]: 
                    self.move(small, large)
            while small and small[0][1] <= i: 
                heapq.heappop(small)
            while large and large[0][1] <= i: 
                heapq.heappop(large)
            ans.append(self.get_med(small, large, k))
        return ans

    def move(self, h1, h2):
        x, i = heapq.heappop(h1)
        heapq.heappush(h2, (-x, i))

    def get_med(self, h1, h2, k):
        return h2[0][0] * 1. if k & 1 else (h2[0][0]-h1[0][0]) / 2.

sol = Solution0480()
nums = [1,3,-1,-3,5,3,6,7]
k = 3
ans = sol.medianSlidingWindow(nums, k)
print(ans)