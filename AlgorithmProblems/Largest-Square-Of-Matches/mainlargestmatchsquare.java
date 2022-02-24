import java.util.Arrays;

/*
Largest Square Of Matches
Medium
Determine the largest square surrounded by a bunch of matches (each match is either horizontal or vertical), return the length of the largest square.

The input is a matrix of points. Each point has one of the following values:

0 - there is no match to its right or bottom.

1 - there is a match to its right.

2 - there is a match to its bottom.

3 - there is a match to its right, and a match to its bottom.



Assumptions

The given matrix is guaranteed to be of size M * N, where M, N >= 0



Examples

{{3, 1, 1, 3, 0, 1, 1, 0},

 {2, 0, 0, 2, 0, 0, 0, 0},

 {3, 1, 3, 0, 0, 0, 0, 0},

 {2, 0, 2, 0, 0, 0, 0, 0},

 {1, 1, 0, 0, 0, 0, 0, 0}}



This matrix represents the following bunch of matches:



The largest square has length of 2.



*/

public class mainlargestmatchsquare {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2,3,3,2},{3,3,3,0},{3,3,3,2},{3,3,3,2},{1,3,1,2},{3,3,3,2},{1,1,3,0},{3,3,3,2},{3,3,3,2},{1,1,1,0}};
        System.out.println("input");
        for (int[] r : matrix) System.out.println(Arrays.toString(r));
        System.out.println();
                                                    
        Solutionlai0638 sol = new Solutionlai0638();
        int res = sol.largestSquareOfMatches(matrix);
        System.out.println("Result: " + res);
    }
}


class Solutionlai0638 {
    public int largestSquareOfMatches(int[][] matrix) {
      // Write your solution here
      // Assumption: matrix is non-null, size M*N
      // elements in matrix are either 0 or 1
      if (matrix.length == 0 || matrix[0].length == 0) {
        return 0;
      }
      int result = 0;
      int M = matrix.length;
      int N = matrix[0].length;
      int[][] right = new int[M+1][N+1];
      int[][] down = new int[M+1][N+1];   
      for (int i = M-1; i>=0; i--) { // range!!!
        for (int j = N-1; j>=0; j--) {
          if (hasRight(matrix[i][j])) {
            right[i][j] = right[i][j+1] + 1;
          }
          if (hasDown(matrix[i][j])) {
            down[i][j] = down[i+1][j] + 1;
          }
          if (hasBoth(matrix[i][j])) {
            for (int maxLength = Math.min(right[i][j], down[i][j]); maxLength >= 1; maxLength--) { // k>=1
              if(right[i+maxLength][j] >= maxLength && down[i][j+maxLength] >= maxLength) { // cross references !!!!!! r move check c, c move check r;
                result = Math.max(result, maxLength);
                break;
              }
            }
          }
        }
      } 
      System.out.println("right");
      for (int[] r : right) System.out.println(Arrays.toString(r));
      System.out.println("down");
      for (int[] d : down) System.out.println(Arrays.toString(d));
      return result;
    }
  
    private boolean hasRight(int value) {
      return (value & 0b1) != 0;
    }
  
    private boolean hasDown(int value) {
      return (value & 0b10) != 0;
    }
  
    private boolean hasBoth(int value) {
      return (value & 0b11) != 0;
    }    
  }
  