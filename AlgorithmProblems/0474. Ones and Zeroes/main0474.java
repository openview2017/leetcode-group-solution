public class main0474 {
    public static void main(String[] args) {
        Solution0474 sol = new Solution0474();
        String[] strs = new String[]{"10","0001","111001","1","0"};
        int m = 5, n = 3;
        int res = sol.findMaxForm(strs, m, n);
        System.out.println(res);

    }
}

class Solution0474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] count = countzeroesones(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--)
                for (int ones = n; ones >= count[1]; ones--)
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
        }
        return dp[m][n];
    }
    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'0']++;
        }
        return c;
    }
}

