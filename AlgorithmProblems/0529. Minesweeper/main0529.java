import java.util.Arrays;

public class main0529 {
    public static void main(String[] args) {
        Solution0529 sol = new Solution0529();
        char[][] board = {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        for (char[] b : board) {
            System.out.println(Arrays.toString(b));
        }
        System.out.println();
        int[] click = {3,0};
        char[][] res = sol.updateBoard(board, click);
        for (char[] b : res) {
            System.out.println(Arrays.toString(b));
        }
    }
}


class Solution0529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = board.length, col = board[0].length;
        int r = click[0], c = click[1];

        if (board[r][c] == 'M') {
            board[r][c] = 'X';
        } else {
            // check the around M of r,c        
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int rc = r + i, cc = c + j;
                    if (rc < 0 || rc >= row || cc < 0 || cc >= col) {
                        continue;
                    }
                    if (board[rc][cc] == 'M' || board[rc][cc] == 'X') {
                        count++;
                    }
                }
            }
            
            if (count > 0) {
                board[r][c] = (char) ('0' + count);    
            } else { // continue DFS to find adjacent E
                board[r][c] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int rc = r + i, cc = c + j;
                        if (rc < 0 || rc >= row || cc < 0 || cc >= col) {
                            continue;
                        }
                        if (board[rc][cc] == 'E') {
                            updateBoard(board, new int[]{rc, cc});
                        }
                    }
                }
            }
        }            
        return board;
    }
}