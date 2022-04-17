from random import randint
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

	# @bubbleSort, TLE
    def bubbleSort(self, nums):
        n = len(nums)
        for i in range(n):
            for j in range(0, n - i - 1):
                if nums[j] > nums[j + 1]:
                    nums[j], nums[j + 1] = nums[j + 1], nums[j]
                    
	# @insertionSort, TLE
    def insertionSort(self, nums): 
        for i in range(1, len(nums)): 
            key = nums[i]
            j = i-1
            while j >= 0 and key < nums[j] : 
                    nums[j + 1] = nums[j] 
                    j -= 1
            nums[j + 1] = key
    
class QuickSort:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.quicksort(nums, 0, len(nums)-1)
        return nums
    
    def quicksort(self, nums, start, end):
        if start >= end:
            return
        
        part = self.part(nums, start, end) # partition the array
        self.quicksort(nums, start, part-1)
        self.quicksort(nums, part+1, end) # dont include the parition idx itself since left..... idx......right
    
    def part(self, nums, left, right):
        idx = left
        ran = randint(left, right)
        nums[right], nums[ran] = nums[ran], nums[right]
        pivot = nums[right]
        
        for i in range(left, right):
            if nums[i] <= pivot:
                nums[idx],nums[i] = nums[i], nums[idx]
                idx+=1
        
        nums[idx],nums[right] = nums[right], nums[idx]
        return idx # return the idx for part

s = MergeSort()
arr = [5,2,3,1]
print(arr)
sorted_arr = s.sortArray(arr)
print(sorted_arr)

s = QuickSort()
arr = [5,2,3,1]
print(arr)
sorted_arr = s.sortArray(arr)
print(sorted_arr)
