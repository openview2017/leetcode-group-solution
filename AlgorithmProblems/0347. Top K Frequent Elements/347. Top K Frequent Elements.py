from typing import List

"""
Solution 1: Quick select
TC: O(N) => Average
SC: O(N)
"""
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq_dict = dict()
        for i in nums:
            if i in freq_dict:
                freq_dict[i] += 1
            else:
                freq_dict[i] = 1
        freq_array = [(value, key) for (key, value) in freq_dict.items()]
        if k > len(freq_array):
            return -1
        self.quickSelect(freq_array, k, 0, len(freq_array)-1)
        return [i[1] for i in freq_array[:k]]

    def quickSelect(self, nums, k, start, end):
        if start == end == k-1:
            return
        l, r = start, end
        pivot = nums[(l+r)//2][0]
        while l <= r:
            if nums[l][0] > pivot:
                l += 1
                continue
            if nums[r][0] < pivot:
                r -= 1
                continue
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r -= 1
        if k-1 <= r:
            result = self.quickSelect(nums, k, start, r)
        elif k-1 >= l:
            result = self.quickSelect(nums, k, l, end)
        return

"""
Solution 1: Heap
TC: O(N*LogN)
SC: O(N)
"""
import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq_dict = dict()
        for i in nums:
            if i in freq_dict:
                freq_dict[i] += 1
            else:
                freq_dict[i] = 1
        min_heap = []
        for num, freq in freq_dict.items():
            heapq.heappush(min_heap, (freq, num))
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        return [i[1] for i in min_heap]