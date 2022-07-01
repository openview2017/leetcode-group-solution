import sys
from typing import List
"""
Using sliding window. Each time record how many 0s in the current window.
Time complexity: O(N)
Space complexity: O(1)
"""
class Solution:
    def minSwaps(self, data: List[int]) -> int:
        window_size = sum(data)  # count how many 1s in total
        cur_count = 0
        min_swap = sys.maxsize
        for i in range(len(data)):
            if i < window_size:
                cur_count += data[i]
            else:
                cur_count += data[i] - data[i-window_size]
            min_swap = min(min_swap, window_size-cur_count)
        return min_swap
        
        