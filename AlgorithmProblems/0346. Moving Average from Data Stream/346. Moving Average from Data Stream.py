from collections import deque
class MovingAverage:

    def __init__(self, size: int):
        self.max_size = size
        self.queue = deque([])
        self.cur_sum = 0

    def next(self, val: int) -> float:
        self.cur_sum += val
        self.queue.append(val)
        if len(self.queue) > self.max_size:
            self.cur_sum -= self.queue.popleft()
        return float(self.cur_sum) / len(self.queue)

# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)