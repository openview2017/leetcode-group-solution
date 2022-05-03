public class main0419 {
    public static void main(String[] args) {
        
    }
}

class Solution0419 { // 12, dfs, optimal space method
    public int countBattleships(char[][] board) {
        int row = board.length, col = board[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '.') continue;
                if (i - 1 >= 0 && board[i-1][j] == 'X') continue;                
                if (j - 1 >= 0 && board[i][j-1] == 'X') continue;
                count++;
            }
        }
        return count;
    }
}
//tc:o(row*col), sc:o(1)