public class main0122 {
    
}


class Solution0122 { 
    public int maxProfit(int[] prices) {
 // [0] empty, [1] have
        int none = 0;
        int keep = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int pk = keep, pn = none;
            none = Math.max(pn, pk + prices[i]);            
            keep = Math.max(pk, pn - prices[i]);
        }
        return none;
    }    
    public int maxProfit0(int[] prices) {
        int[][] dp = new int[prices.length][2]; // [0] empty, [1] have
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);            
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }
}