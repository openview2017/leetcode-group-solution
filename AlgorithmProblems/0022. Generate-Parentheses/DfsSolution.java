/*
dfs
TC: O(2^n)
SC: O(n)
how many levels: n, each level is a position in one of the result
for each level, choose left or right parenthese, two branches

*/

class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        dfs(n, sb, res, 0, 0, 0);
        return res;
    }
    private void dfs(int n, StringBuilder sb, List<String> res, int index, int left, int right) {
        if (index == 2 * n) {
            res.add(sb.toString());
            return;
        }
        
        if (left < n) {
            sb.append('(');
            dfs(n, sb, res, index + 1, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (right < left) {
            sb.append(')');
            dfs(n, sb, res, index + 1, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}