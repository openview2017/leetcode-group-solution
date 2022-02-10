public class main1277 {
    public static void main(String[] args) {
        Solution1277 sol = new Solution1277();
        int[][] matrix;
        int res;

        matrix = new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        res = sol.countSquares(matrix);
        System.out.println(res);
    }
}


class Solution1277 {
    public int countSquares(int[][] matrix) {
        int count = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    count += matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    matrix[i][j] = Math.min(matrix[i-1][j-1], matrix[i-1][j]) + 1;
                    matrix[i][j] = Math.min(matrix[i][j-1] + 1, matrix[i][j]);
                    count += matrix[i][j];
                }
            }
        }
        return count;
    }
}

/*
method: dp

dp[i][j] - i,j end largest length of square
count = 0; // square
   0 1 1 1
  [0,1,1,1],
   1 1 2
  [1,1,1,1],
  
  [0,1,1,1]

//tc: o(row*col)
// sc: o(row*col)
     => o(col+1)
*/