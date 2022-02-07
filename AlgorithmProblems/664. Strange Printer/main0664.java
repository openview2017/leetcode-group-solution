public class main0664 {
    public static void main(String[] args) {
        Solution0664 sol = new Solution0664();
        String s;
        int res;

        s = "aaabbb";
        res = sol.strangePrinter(s);
        System.out.println(s + ":" + res);

        s = "aba";
        res = sol.strangePrinter(s);
        System.out.println(s + ":" + res);        
    }
}
// tc: o(n3), sc:o(n2)
// reference: https://leetcode-cn.com/problems/strange-printer/solution/qi-guai-de-da-yin-ji-by-leetcode-solutio-ogbu/
class Solution0664 {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    int minn = j - i + 1;
                    for (int k = i; k < j; k++) {
                        minn = Math.min(dp[i][k] + dp[k+1][j], minn);
                    }
                    dp[i][j] = minn;
                }
            }
        }
        return dp[0][n-1];
    }
}