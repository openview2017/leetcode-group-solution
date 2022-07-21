public class main0790 {
    
}

class Solution0790 {
    public int numTilings(int n) {
        long[] dp = new long[3];
        long MOD = 1_000_000_007;
        dp = new long[]{1, 0, 0, 1}; // 1
        long[] tmp;
        for (int i = 2; i <= n; i++) {
            tmp = new long[]{0, 0, 0, 0};
            tmp[0] = dp[3];
            tmp[1] = (dp[0] + dp[2]) % MOD;
            tmp[2] = (dp[0] + dp[1]) % MOD;
            tmp[3] = (dp[0] + dp[1] + dp[2] + dp[3]) % MOD;
            dp = tmp;
        }
        return (int) (dp[3] % MOD);
    }
}