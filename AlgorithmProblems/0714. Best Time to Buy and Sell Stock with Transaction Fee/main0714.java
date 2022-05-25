public class main0714 {
    
}


class Solution { // dp 05 - 18. 3 methods
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0], sell = 0;
        for (int i = 0; i < prices.length; i++) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }     
    public int maxProfit1(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[2][2]; // dp[][0] have at i, dp[][1] not have at i
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) { // i%2==1
            dp[i%2][0] = Math.max(dp[1-i%2][0], dp[1-i%2][1] - prices[i]);
            dp[i%2][1] = Math.max(dp[1-i%2][1], dp[1-i%2][0] + prices[i] - fee);
        }
        return dp[1-len%2][1];
    }    
    public int maxProfit0(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2]; // dp[][0] have at i, dp[][1] not have at i
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] - fee);
        }
        return dp[len-1][1];
    }
}
