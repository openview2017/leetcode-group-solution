/*
TC: O(n*m) 走2遍
SC: O（1）

step1: 对于左边第一列，如果有一个0，标注一下；对于上面第一行，如果有一个0，也可以标注一下
step2: 对于剩下的行和列，如果某个grid是0，标注到左边第一列，和上面第一行去
step3: 根据左边第一列和上面第一行，把该放入的0放入

*/
class Solution {
  public void setZeroes(int[][] matrix) {
    boolean firstCol = false;
    boolean firstRow = false;
      
    int R = matrix.length;
    int C = matrix[0].length;

    for (int i = 0; i < R; i++) { // O(m)
      if (matrix[i][0] == 0) {
        firstCol = true;
      }
    }
      
    for (int i = 0; i < C; i++) { // O(n)
        if (matrix[0][i] == 0) {
            firstRow = true;
        }
    }
      
    for (int i = 1; i < R; i++) { // O(m*n)
        for (int j = 1; j < C; j++) {
        // If an element is zero, we set the first element of the corresponding row and column to 0
            if (matrix[i][j] == 0) {
            matrix[0][j] = 0;
            matrix[i][0] = 0;
        }
      } 
    }
      
    // Iterate over the array once again and using the first row and first column, update the elements.
    for (int i = 1; i < R; i++) { // O(m*n)
      for (int j = 1; j < C; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // See if the first row needs to be set to zero as well
    if (firstRow) { // O(n)
      for (int j = 0; j < C; j++) {
        matrix[0][j] = 0;
      }
    }

    // See if the first column needs to be set to zero as well
    if (firstCol) { // O(m)
      for (int i = 0; i < R; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}