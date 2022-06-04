public class main0598 {
    public static void main(String[] args) {
        Solution0598 sol = new Solution0598();
        int m, n, ops[][];
        m = 3;
        n = 3;
        ops = new int[][]{{2,2},{3,3}};
        int res = sol.maxCount(m, n, ops);
        System.out.println(res);
    }
}


class Solution0598 {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(m, op[0]);            
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
}