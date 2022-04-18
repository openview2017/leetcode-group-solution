from typing import List
"""
Solution 1: Using quick partition to find the Kth largest.
Time complexity: average O(N), worst case O(N^2).
Space complexity: O(1)
"""
class Solution1:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return self.quickSelect(nums, k, 0, len(nums)-1)
        
    def quickSelect(self, nums, k, start, end):
        if start == end == k-1:
            return nums[k-1]
        l, r = start, end
        pivot = nums[(l+r)//2]
        while l <= r:
            if nums[l] > pivot:
                l += 1
                continue
            if nums[r] < pivot:
                r -= 1
                continue
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r -= 1
        if k-1 <= r:
            result = self.quickSelect(nums, k, start, r)
        elif k-1 >= l:
            result = self.quickSelect(nums, k, l, end)
        else:
            return nums[k-1]
        return result

"""
Solution 1: Using quick partition to find the Kth largest.
Time complexity: O(N*logk)
Space complexity: O(k)
"""
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for i in nums:
            heapq.heappush(heap, i)
            if len(heap) > k:
                heapq.heappop(heap)
        return heap[0]
        