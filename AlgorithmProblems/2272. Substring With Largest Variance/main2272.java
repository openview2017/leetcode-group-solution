import java.util.Arrays;

class main2272{
    public static void main(String[] args) {
        Solution2272 sol = new Solution2272();
        String s = "aababbb";
        int res = sol.largestVariance(s);
        System.out.println(res);
    }
}

class Solution2272 { // 00 - 11
    public int largestVariance(String s) {
        int n = s.length(), res = 0;
        int[] dp0 = new int[n+1];
        int[] dp1 = new int[n+1];
        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (i == j) continue;
                dp0[0] = 0;
                dp1[0] = -n-1; // dp0 w b, dp 1 wo b
                for (int k = 0; k < n; k++) {
                    char ch = s.charAt(k);
                    int v = ch == i ? 1 : (ch == j ? -1 : 0);
                    // dp0 = Math.max(v, dp0 + v);
                    dp0[k+1] = Math.max(v, dp0[k] + v);
                    if (ch == j) {
                        // dp1 = dp0;  
                        dp1[k+1] = dp0[k+1];
                    } else {
                        // dp1 = dp1 + v;
                        dp1[k+1] = dp1[k] + v;
                    } 
                    // res = Math.max(res, dp1);
                    res = Math.max(res, dp1[k+1]);
                }
                if (i == 'b' && j == 'a') {
                    System.out.println(Arrays.toString(dp0));                    
                    System.out.println(Arrays.toString(dp1));
                }
            }
        }
        return res;
    }
}
/*

aabbbbaa

ab
      a   a  b  b
 0    1   2  3  4   5   6  7  8
[0,   1,  2, 1, 0, -1, -1, 1, 2]
[-9, -8, -7, 1, 0, -1, -1, 0, 1]

ba

      a   a  b  b  b
 0    1   2  3  4  5  6  7  8
[0,  -1, -1, 1, 2, 3, 4, 3, 2]
[-9, -1, -1, 0, 1, 2, 3, 3, 2]

*/