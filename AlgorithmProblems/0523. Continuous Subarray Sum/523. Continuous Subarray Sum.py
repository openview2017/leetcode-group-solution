from typing import List
"""
Each time add the current prefix_sum remainder to a seen set. If we see the same remainder again, then the subarray in between is multiple of k.
Because there is a limitation of subarray of size at least two elements, we are adding the cur_sum to the seen set in next round not in current round.
Otherwise we will count the subarray with only one element in.
Time complexity: O(N)
Space complexity: O(N)
"""
class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        memo = set()
        cur_sum = 0
        for i in range(0, len(nums)):
            new_sum = (cur_sum + nums[i]) % k
            if new_sum in memo:
                return True
            else: 
                memo.add(cur_sum)
                cur_sum = new_sum
        return False
                