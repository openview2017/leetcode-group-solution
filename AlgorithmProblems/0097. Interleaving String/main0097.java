public class main0097 {
    
}


class Solution0097 { // 31 - 39
    public boolean isInterleave(String s1, String s2, String s3) { // tc:o(mn), sc:o(n)
        int m = s1.length(), n = s2.length(), o = s3.length();
        if (m + n != o) return false;
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[j] = (dp[j] && s1.charAt(i-1) == s3.charAt(p));
                }
                if (j > 0) {
                    dp[j] = dp[j] || (dp[j-1] && s2.charAt(j-1) == s3.charAt(p));
                }
            }
        }
        return dp[n];
    }
    public boolean isInterleave0(String s1, String s2, String s3) { // tc/sc:o(mn)
        int m = s1.length(), n = s2.length(), o = s3.length();
        if (m + n != o) return false;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) { 
            for (int j = 0; j <= n; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i + j - 1));    
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[m][n];
    }
}
// ref: https://leetcode.cn/problems/interleaving-string/solution/jiao-cuo-zi-fu-chuan-by-leetcode-solution/