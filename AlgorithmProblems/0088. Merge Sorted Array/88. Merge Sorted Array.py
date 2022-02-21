from typing import List

"""
Iterating backward with 3 pointers.
TC: O(M+N)
SC: O(1)
"""
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        left, right = m-1, n-1
        cur = m+n-1
        while left >= 0 and right >=0:
            if nums1[left] >= nums2[right]:
                nums1[cur] = nums1[left]
                left -= 1
            else:
                nums1[cur] = nums2[right]
                right -= 1
            cur -= 1
        while left >= 0:
            nums1[cur] = nums1[left]
            left -= 1
            cur -= 1
        while right >= 0:
            nums1[cur] = nums2[right]
            right -= 1
            cur -= 1 
        return


"""
Iterating Forward with 3 pointers. Need to copy the elements in nums1 to the end of array. 
TC: O(M+N)
SC: O(1)
"""
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        for i in range(1, m+1):
            nums1[n+m-i] = nums1[m-i]
        left, right = n, 0
        cur = 0
        while left < m+n and right < n:
            if nums1[left] <= nums2[right]:
                nums1[cur] = nums1[left]
                left += 1
            else:
                nums1[cur] = nums2[right]
                right += 1
            cur += 1
        while left < m+n:
            nums1[cur] = nums1[left]
            left += 1
            cur += 1
        while right < n:
            nums1[cur] = nums2[right]
            right += 1
            cur += 1
        return