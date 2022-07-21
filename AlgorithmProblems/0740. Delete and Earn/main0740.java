public class main0740 {
    
}

class Solution0740 { 
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] vals = new int[maxVal + 1];
        for (int num : nums) {
            vals[num] += num;
        }
        // dp[i] - 1-i largest point
        int[] dp = new int[maxVal + 1];
        dp[1] = vals[1];
        for (int i = 2; i <= maxVal; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + vals[i]); 
        }
        return dp[maxVal];
    }
}