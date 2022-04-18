class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    
    //物理意义：当前的board，with当前填过的数，是否有一个valid的填剩下的方法。
    private boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (helper(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false; // 说明对于当前这个位置，1-9填进去，都不会有一个最后return true的，那这整个只能return false了
                }
            }
        }
        //最后，又没return true，又没return false，是什么情况呢？
        //说明都填完了，没有进入到10行；然后也没有任何一个空格的地方return了false。那就可以return true，相当于填完了
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
            if (board[i][col] == num) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}