import heapq
class KthLargestCombinationSum:
    def findKthLargest(self, array, k):
        combinationSum = []
        self.dfs(array, 0, 0, combinationSum)
        min_heap = []
        for i in combinationSum:
            heapq.heappush(min_heap, i)
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        min_heap = sorted(min_heap, reverse=True)
        return min_heap

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
    