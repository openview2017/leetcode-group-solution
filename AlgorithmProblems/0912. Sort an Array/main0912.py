from typing import List

class MergeSort:
    def sortArray(self, nums: List[int]) -> List[int]:
        #mergesort
        if len(nums) <= 1:
            return nums
        middle = len(nums) // 2
        left = self.sortArray(nums[:middle])
        right = self.sortArray(nums[middle:])
        merged = []
        while left and right:
            if left[0] <= right [0]:
                merged.append(left.pop(0))
            else:
                merged.append(right.pop(0))
        merged.extend(right if right else left)
        return merged

s = MergeSort()
arr = [5,2,3,1]
print(arr)
sorted_arr = s.sortArray(arr)
print(sorted_arr)