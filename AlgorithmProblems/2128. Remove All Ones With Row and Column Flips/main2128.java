

/*

2128. Remove All Ones With Row and Column Flips
Medium

You are given an m x n binary matrix grid.

In one operation, you can choose any row or column and flip each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).

Return true if it is possible to remove all 1's from grid using any number of operations or false otherwise.

 

Example 1:


Input: grid = [[0,1,0],[1,0,1],[0,1,0]]
Output: true
Explanation: One possible way to remove all 1's from grid is to:
- Flip the middle row
- Flip the middle column
Example 2:


Input: grid = [[1,1,0],[0,0,0],[0,0,0]]
Output: false
Explanation: It is impossible to remove all 1's from grid.
Example 3:


Input: grid = [[0]]
Output: true
Explanation: There are no 1's in grid.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is either 0 or 1.


*/
import java.util.Arrays;

public class main2128 {
    public static void main(String[] args) {
        Solution2128 sol = new Solution2128();
        int[][] grid;
        boolean res;

        grid = new int[][]{{0,1,0},{1,0,1},{0,1,0}};
        System.out.println(Arrays.deepToString(grid));    
        res = sol.removeOnes(grid);
        System.out.println(res);

        grid = new int[][]{{1,1,0},{0,0,0},{0,0,0}};
        System.out.println(Arrays.deepToString(grid));    
        res = sol.removeOnes(grid);
        System.out.println(res);
    }


}
/*
tc: O(row * col)
sc: o(1)
*/
class Solution2128 { 
    public boolean removeOnes(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return false;
        }
        int row = grid.length, col = grid[0].length;
        if (row == 1 || col == 1) {
            return true;
        }
        for (int i = 0; i < row - 1; i++) {
            if (!isSameRow(grid, i, i+1) && !isCompRow(grid, i, i+1)) {
                return false;
            }
        } 
        return true;
    }
    
    private boolean isSameRow(int[][] grid, int r1, int r2) {
        int col = grid[0].length;
        for (int c = 0; c < col; c++) {
            if (grid[r1][c] != grid[r2][c]) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isCompRow(int[][] grid, int r1, int r2) {
        int col = grid[0].length;
        for (int c = 0; c < col; c++) {
            if (grid[r1][c] != 1 - grid[r2][c]) {
                return false;
            }
        }
        return true;
    }
}