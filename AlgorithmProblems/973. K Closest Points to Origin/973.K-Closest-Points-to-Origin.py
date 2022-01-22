"""
Solution 1: Max heap solution
Time complexity: O(N) + O(N*log(N)) + O(K) = O(N*log(N))
Space complexity: O(K) + O(N) = O(N)
"""
import heapq
import math
from typing import List
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        distances = [(-math.sqrt(i**2 + j**2), i, j) for i, j in points] # [(distance, xi, yi)]
        heap = []
        for d in distances:
            heapq.heappush(heap, d)
            if len(heap) > k: # Maintain a max heap of length k
                heapq.heappop(heap)
        return [(i[1], i[2]) for i in heap]

"""
Solution 2: Quick partition - Same as 215.Kth largest Element in an array
Time complexity: O(N) - Average  O(N**2) - worst case
Space complexity: O(1)
"""
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        self.quickPartition(points, 0, len(points)-1, k)
        return [i for i in points[:k]]
        
    def quickPartition(self, points, start, end, k):
        # recursion exit
        if start >= end:
            return
        l, r = start, end
        pivot = self.dist(points[(l+r)//2]) # pivot can be a number at any position in the array.
        while l <= r:
            if self.dist(points[l]) < pivot:
                l += 1
                continue
            if self.dist(points[r]) > pivot:
                r -= 1
                continue
            points[l], points[r] = points[r], points[l]
            l += 1
            r -= 1
        # we use k-1 because the kth element's index is k-1
        if k-1 <= r:
            self.quickPartition(points, start, r, k)
        elif k-1 >= l:
            self.quickPartition(points, l, end, k)
        else:
            return
    
    def dist(self, position):
        return position[0]**2 + position[1]**2
