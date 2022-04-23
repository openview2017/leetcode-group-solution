
class Solution153(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        lo, hi = 0, len(nums)-1
        while lo < hi:
            mid = lo + (hi - lo) // 2
            if nums[mid] > nums[hi]:
                lo = mid + 1
            else:
                hi = mid
        return nums[lo]
#  [4,5,6,7,0,1,2] 
    def findMin_post(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        lo, hi = 0, len(nums) - 1
        if nums[hi] > nums[lo]:  # !!!!!!!!! passed
            return nums[lo]
        while lo < hi - 1:
            mid = lo + (hi - lo) // 2
            # if nums[mid-1] > nums[mid]:
            #     return nums[mid]
            if nums[mid] < nums[lo]:
                hi = mid
            else:
                lo = mid
        
        return min(nums[lo], nums[hi])

sol = Solution153()
nums = [4,5,6,7,0,1,2]
res = sol.findMin(nums)
print(res)
