import java.util.Arrays;

public class main0311 {
    public static void main(String[] args) {
        Solution311 sol = new Solution311();
        int[][] mat1, mat2;
        int[][] res;
        mat1 = new int[][]{{1,0,0},{-1,0,3}};
        mat2 = new int[][]{{7,0,0},{0,0,0},{0,0,1}};
        res = sol.multiply0(mat1, mat2);
        System.out.println("Mat1   : " + Arrays.deepToString(mat1));
        System.out.println("Mat1   : " + Arrays.deepToString(mat2));
        System.out.println("Result : " + Arrays.deepToString(res));
    }
}

class Solution311 {
    public int[][] multiply0(int[][] mat1, int[][] mat2) {
        int r1 = mat1.length, c1 = mat1[0].length;
        int r2 = mat2.length, c2 = mat2[0].length;
        int[][] res = new int[r1][c2];
        for (int k = 0; k < c1; k++) {
            for (int i = 0; i < r1; i++) {
                if (mat1[i][k] == 0) continue;
                for (int j = 0; j < c2; j++) {
                    if (mat2[k][j] == 0) continue;
                    res[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return res;
    }
    
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int r1 = mat1.length, c1 = mat1[0].length;
        int r2 = mat2.length, c2 = mat2[0].length;
        int[][] res = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    res[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return res;
    }
}

/*
 a*b  b*c  -> a*c
//  sum(a[i][:] * b[:][j])           c[i][j]

method:
1. change the sequence of loop, move k to outer
2. check A[i][k] == 0? 

tc: o(r1c1c2) r - r1 * c1 * c2, with scape 0 elements
sc: o(1)
*/