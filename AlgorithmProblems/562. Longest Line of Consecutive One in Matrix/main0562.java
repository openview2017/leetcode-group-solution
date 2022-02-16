public class main0562 {
    public static void main(String[] args) {
        Solution0562 sol = new Solution0562();
        int[][] M;
        int res;

        M = new int[][]{{1,1,1,1},{0,1,1,0},{0,0,0,1}};
        res = sol.longestLine(M);
        System.out.println(res);
    }
}

class Solution0562 {
    public int longestLine(int[][] M) {
      if (M.length == 0) return 0;
      int ones = 0;
      int[][] dp = new int[M[0].length][4];
      for (int i = 0; i < M.length; i++) {
        int old = 0;
        for (int j = 0; j < M[0].length; j++) {
          if (M[i][j] == 1) {
            dp[j][0] = j > 0 ? dp[j - 1][0] + 1 : 1;
            dp[j][1] = i > 0 ? dp[j][1] + 1 : 1;
            int prev = dp[j][2];
            dp[j][2] = (i > 0 && j > 0) ? old + 1 : 1;
            old = prev;
            dp[j][3] = (i > 0 && j < M[0].length - 1) ? dp[j + 1][3] + 1 : 1;
            ones =
                Math.max(ones, Math.max(Math.max(dp[j][0], dp[j][1]), Math.max(dp[j][2], dp[j][3])));
          } else {
            old = dp[j][2];
            dp[j][0] = dp[j][1] = dp[j][2] = dp[j][3] = 0;
          }
        }
      }
      return ones;
    }
  }
  /*
  
  dp[i][j][0-4]
  
  ??????????????????[0]- [1]| [2]/ 3[\]
  [0]- [1]| [2]\  [3]/
              ?
  4                     0,1,2,3
  dp[i][j][]  - dp[col][status]
  prevCol = xxx;
  
  dp[j][0] = (dp[j-1][0] + mat[i][j]),0                          ; col0: mat[i][0]
  dp[j][1] = dp[j][1] + mat[i][j], 0; update prevCol - dp[j][1]    row0: mat[0][j]
  dp[j][2] = (dp[j-1][2])-> prevCol + 1, 0                               mat[i][j]
  dp[j][3] = dp[j+1][3]+1, 0                                             mat[i][j]
  
  tc: o(row*col)
  sc: O(col + 1)
  */