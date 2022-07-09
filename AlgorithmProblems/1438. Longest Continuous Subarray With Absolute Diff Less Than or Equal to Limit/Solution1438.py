from collections import deque
import collections
from typing import List


class Solution1438:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        n = len(nums)
        i = 0
        max_len = 0
        dq_max, dq_min = deque(), deque()
        for j in range(n):
            while dq_max and dq_max[-1] < nums[j]:
                dq_max.pop()
            dq_max.append(nums[j])
            while dq_min and dq_min[-1] > nums[j]:
                dq_min.pop()
            dq_min.append(nums[j])
            
            while dq_max[0] - dq_min[0] > limit:
                if dq_max[0] == nums[i]:
                    dq_max.popleft()
                if dq_min[0] == nums[i]:
                    dq_min.popleft()
                i += 1
            max_len = max(max_len, j - i + 1)
            
        return max_len
            
    def longestSubarray0(self, A, limit): #lee215
        maxd = collections.deque()
        mind = collections.deque()
        i = 0
        for a in A:
            while len(maxd) and a > maxd[-1]: maxd.pop()
            while len(mind) and a < mind[-1]: mind.pop()
            maxd.append(a)
            mind.append(a)
            if maxd[0] - mind[0] > limit:
                if maxd[0] == A[i]: maxd.popleft()
                if mind[0] == A[i]: mind.popleft()
                i += 1
        return len(A) - i        