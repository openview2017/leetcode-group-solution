"""
First generate the combination sum full set with DFS.
Use a heap with lenght k to get the k largest elements.

Time complexity: O(2^N*logK)
Space complexity: O(2^N)

There is another implementation with lower time complexity: O(N + 2^Min(N,K)*logK)
[-5, -3, -1, 2, 4]  k=2
First, get the sum of all positive numbers, which is the largest number in the combination sum.
2 + 4 = 6
Then find the k smallest elements by their absolute value.
k=2
[-5, -3, -1, 2, 4]
          |  |
Third, make all of the k smallest element positive and find all the combination sum of them.
-1, 2 => 1, 2
[] = 0
[1]
[2]
[1,2] = 3 (Not within k)
Sort the combination sum from small to large.
[1,2,3]
Use the largest value (positive sum got from first step) minus all of these small values and return the array.
[6-0, 6-1, 6-2] = [6, 5, 4]
"""

import heapq
class KthLargestCombinationSum:
    def findKthLargest(self, array, k):
        combinationSum = []
        self.dfs(array, 0, 0, combinationSum)
        min_heap = []
        for i in combinationSum:
            # use heap with length k to get the first k largest elements.
            heapq.heappush(min_heap, i)
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        min_heap = sorted(min_heap, reverse=True)
        return min_heap

    # Generate all combinations sum value and fill into the combinationSum array.
    def dfs(self, array, cur_sum, idx, combinationSum):
        if idx >= len(array):
            combinationSum.append(cur_sum)
            return
        self.dfs(array, cur_sum+array[idx], idx+1, combinationSum)
        self.dfs(array, cur_sum, idx+1, combinationSum)
        return

if __name__ == "__main__":
    # Test case1
    array = [3,5,-2]
    k = 3  
    c = KthLargestCombinationSum()
    print(c.findKthLargest(array, k))
    print("Expected result: {}".format([8,6,5]))

    # Test case2
    array = [1, 2, -2]
    k = 2  
    c = KthLargestCombinationSum()
    print(c.findKthLargest(array, k))
    print("Expected result: {}".format([3, 2]))
    