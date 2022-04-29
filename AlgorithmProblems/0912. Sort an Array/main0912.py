from random import randint
from typing import List

class Sort:
    def mergeSort(self, nums: List[int]) -> List[int]:
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

    def sortArray(self, nums: List[int]) -> List[int]:
        def quicksort(A, low, high):
            if low >= high: return
            p = partition(A, low, high)
            quicksort(A, low, p-1), 
            quicksort(A, p + 1, high)
        
        def partition(A, low, high):
            # swap median with pivot
            mid = (low + high) // 2
            A[high], A[mid] = A[mid], A[high]
            i = low - 1

            for j in range(low, high):
                if A[j] < A[high]: 
                    i = i + 1
                    A[i], A[j] = A[j], A[i]
                    
            A[high], A[i+1] = A[i+1], A[high]
            return i + 1
        
        quicksort(nums,0,len(nums) - 1)
        return nums            
    
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

s = Sort()
arr = [5,2,3,1]
print(arr)
sorted_arr = s.mergeSort(arr)
print(sorted_arr)
print()

s = Sort()
arr = [5,2,3,1]
print(arr)
sorted_arr = s.sortArray(arr)
print(sorted_arr)
print()

s = QuickSort()
arr = [5,2,3,1]
print(arr)
sorted_arr = s.sortArray(arr)
print(sorted_arr)
