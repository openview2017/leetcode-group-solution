from typing import List
import sys
"""
Sort envelope height in increasing order, if same value appears, sort by decreasing order on width.
Get the array of width and then do longest increasing subsequence.
Using binary search dynamic programming will decrease the TC.
TC: O(N*logN)
SC: O(N)
"""
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes = sorted(envelopes, key = lambda x: (x[0], -x[1]))
        width = [i[1] for i in envelopes]
        return self.longestIncreasingSubsequence(width)
    
    def longestIncreasingSubsequence(self, array):
        smallest_last_elements = [sys.maxsize] * len(array)
        for i in array:
            index = self.binarySearch(smallest_last_elements, 0, len(array)-1, i)
            smallest_last_elements[index] = i
        for j in range(len(smallest_last_elements)-1, -1, -1):
            if smallest_last_elements[j] != sys.maxsize:
                return j+1
        return -1
    
    # Find the left most element larger than or equal to target which will be replaced by current value.
    def binarySearch(self, array, left, right, target):
        while left + 1 < right:
            mid = (left + right) // 2
            if array[mid] >= target:
                right = mid
            else:
                left = mid
        if array[left] >= target:
            return left
        return right