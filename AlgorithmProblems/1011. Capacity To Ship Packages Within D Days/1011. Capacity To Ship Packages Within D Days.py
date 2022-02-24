from typing import List
"""
Binary search
TC: O(logM*N) M is the sum of weights, N is length of Weights
SC: O(1)
"""
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        if days >= len(weights):
            return max(weights)
        sum_weight = sum(weights)
        min_cap = max(weights)
        max_cap = sum_weight
        return self.binarySearch(weights, min_cap, max_cap, days)
 
    def binarySearch(self, weights, left, right, days):
        while left + 1 < right:
            mid = (left + right) // 2
            if self.validate(weights, mid, days):
                right = mid
            else:
                left = mid
        if self.validate(weights, left, days):
            return left
        return right

    def validate(self, weights, capacity, days):
        cur_sum = 0
        for i in weights:
            if cur_sum + i > capacity:
                cur_sum = 0
                days -= 1
            cur_sum += i
        return days > 0