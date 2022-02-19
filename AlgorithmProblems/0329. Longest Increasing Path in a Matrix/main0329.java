import java.util.Arrays;

public class main0329 {
    public static void main(String[] args) {
        Solution0329 sol = new Solution0329();
        int[][] matrix;
        int longest;
        
        matrix = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        longest = sol.longestIncreasingPath(matrix);
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(longest);
    }
}

class Solution0329 { // 25 - 32
    int[][] DIRS = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] dp = new int[r][c]; // max length starting from r,c
        for (int[] dpp : dp) {
            Arrays.fill(dpp,1);
           // System.out.println(Arrays.toString(dpp));
        }
        int longest = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                longest = Math.max(longest, dfs(i, j, matrix, dp));
            }
        }
        // for (int[] dpp : dp) {
        //     //Arrays.fill(dpp,1);
        //     System.out.println(Arrays.toString(dpp));
        // }        
        return longest;
    }
    
    private int dfs(int r, int c, int[][] matrix, int[][] dp) {
        int row = matrix.length, col = matrix[0].length;
        if (dp[r][c] != 1) {
            return dp[r][c];
        }
        //int maxLen = 1;
        for(int[] dir : DIRS) {
            int nxtr = r + dir[0];
            int nxtc = c + dir[1];
            if (nxtr >= 0 && nxtr < row && nxtc >= 0 && nxtc < col && matrix[nxtr][nxtc] > matrix[r][c]) {
               dp[r][c] = Math.max(dp[r][c], dfs(nxtr, nxtc, matrix, dp)+1); 
            }
        }
        return dp[r][c];
    }
}
