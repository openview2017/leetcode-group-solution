class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        
        res = []                                         # list to store max of sliding window
        q = deque([])                                    # monostone queue used to keep largest value in top of queue

        for i, n in enumerate(nums):
            
            while q and q[0] <= i - k:                   # keep queue in rang of k since queue[0] shoule be always <= i - k
                q.popleft()
            
            while q and nums[q[-1]] < n:                 # deque if last value of queue < n to  maintain a monostone queue
                q.pop()
                
            q.append(i)                                  # enque
            if i >= k - 1:
                res.append(nums[q[0]])                   # append max of sliding window to res
                
        return res
