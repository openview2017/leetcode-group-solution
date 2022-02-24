/*
54和59的spiral matrix是一样的做法，在外剥洋葱，然后recursion进入里面一层。
在进入recursion时，size减去2，index加上1
Base case：size == 0, 可以直接结束； size == 1， 把最后一个或者最后一排加入result
*/

// 54. Spiral Matrix
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        helper(matrix, 0, row, col, res);
        return res;
    }
    private void helper(int[][] matrix, int index, int row, int col, List<Integer> res) {
        if (row == 0 || col == 0) {
            return;
        }
        if (row == 1) {
            for (int i = 0; i < col; i++) {
                res.add(matrix[index][i + index]);
            }
            return;
        }
        if (col == 1) {
            for (int i = 0; i < row; i++) {
                res.add(matrix[i + index][index]);
            }
            return;
        }
        
        for (int i = 0; i < col - 1; i++) {
            res.add(matrix[index][i + index]);
        }
        for (int i = 0; i < row - 1; i++) {
            res.add(matrix[i + index][col - 1 + index]);
        }
        for (int i = col - 1; i >= 1; i--) {
            res.add(matrix[row - 1 + index][i + index]);
        }
        for (int i = row - 1; i >= 1; i--) {
            res.add(matrix[i + index][index]);
        }
        helper(matrix, index + 1, row - 2, col - 2, res);
    }
}


// 59. Spiral Matrix II
class Solution {

    public int[][] generateMatrix(int n) {
        int[] a = {1};
        int[][] matrix = new int[n][n];
        helper(matrix, a, n, 0);
        return matrix;
    }
    
    private void helper(int[][] matrix, int[] a, int n, int index) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            matrix[index][index] = a[0]++;
            return;
        }
        
        for (int i = 0; i < n - 1; i++) {
            matrix[index][index + i] = a[0]++;
        }
        for (int i = 0; i < n - 1; i++) {
            matrix[i + index][n - 1 + index] = a[0]++;
        }
        for (int i = n - 1; i >= 1; i--) {
            matrix[n - 1 + index][i + index] = a[0]++;
        }
        for (int i = n - 1; i >= 1; i--) {
            matrix[i + index][index] = a[0]++;
        }

        helper(matrix, a, n - 2, index + 1);
    }
}