class Solution0122:
    def maxProfit0(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[0]*2]*n
        # 0-keep, 1-sell
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        
        for i in range(1, n):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])            
            dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
            
        return dp[n-1][0]
    
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        keep, sell = -prices[0],0
        for i in range(1, n):
            pk, ps = keep, sell
            keep = max(pk, ps - prices[i])            
            sell = max(ps, pk + prices[i])
        return sell

            