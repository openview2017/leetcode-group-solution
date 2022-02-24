class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(n, cur, res);
        return res;
    }
    
    private void helper(int n, List<Integer> cur, List<List<String>> res) {
        if (cur.size() == n) {
            res.add(convert(cur));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (isValid(cur, i)) {
                cur.add(i);
                helper(n, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private List<String> convert(List<Integer> list) {
        List<String> res = new ArrayList<>();
        int n = list.size();
        char[][] board = new char[n][n];
        
        for (char[] b : board) {
            Arrays.fill(b, '.');
        }

        int row = 0;
        for (int i : list) {
            board[row++][i] = 'Q';
        }
        
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }

    private boolean isValid(List<Integer> cur, int col) {
        // i, cur.get(i); size, col; row, col
        int size = cur.size();
        for (int i = 0; i < size; i++) {
            // isvalid里面这里的判断条件时最关键的。
            if (col == cur.get(i) || Math.abs(i - size) == Math.abs(cur.get(i) - col)) {
                return false;
            }  
        }
        return true;
    }
}