public class main0542 {
    
}


class Solution { // 07 - 12 - 17
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = mat[i][j] == 0 ? 0 : row*col+1;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i > 0) { // not 1!!!
                    dp[i][j] = Math.min(dp[i-1][j] + 1, dp[i][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j-1] + 1, dp[i][j]);
                }
            }
        }
        for (int i = row-1; i >= 0; i--) {
            for (int j = col-1; j >= 0; j--) {
                if (i + 1 < row) {
                    dp[i][j] = Math.min(dp[i+1][j] + 1, dp[i][j]);
                }
                if (j + 1 < col) {
                    dp[i][j] = Math.min(dp[i][j+1] + 1, dp[i][j]);
                }
            }
        }        
        
        return dp;
    }
}

//https://leetcode.cn/problems/01-matrix/solution/2chong-bfs-xiang-jie-dp-bi-xu-miao-dong-by-sweetie/