from typing import List


class Solution0121:
    def maxProfit(self, prices: List[int]) -> int:
        res, curmin = 0, prices[0]
        n = len(prices)
        for i in range(n):
            res = max(res, prices[i] - curmin)
            curmin = min(curmin, prices[i])
        return res