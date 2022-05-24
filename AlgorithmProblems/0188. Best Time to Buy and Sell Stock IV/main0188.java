public class main0188 {
    public static void main(String[] args) {
        Solution0188 sol = new Solution0188();
        int k = 2;
        int[] prices = new int[]{2,4,1};
        int res = sol.maxProfit(k, prices);
        System.out.println(res);
    }
}

class Solution0188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            //int localMax = dp[i-1][0] - prices[0];
            int localMax = - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
                localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
            }
            //System.out.println(Arrays.toString(dp[i]));
        }
        return dp[k][n-1];
    }
}
/**
 * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
 * dp[0, j] = 0; 0 transactions makes 0 profit
 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
 */
