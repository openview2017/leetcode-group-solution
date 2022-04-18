import heapq
class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.max_len = k
        self.heap = []
        for i in nums:
            self.add(i)
        

    def add(self, val: int) -> int:
        heapq.heappush(self.heap, val)
        if len(self.heap) > self.max_len:
            heapq.heappop(self.heap)
        return self.heap[0]


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)