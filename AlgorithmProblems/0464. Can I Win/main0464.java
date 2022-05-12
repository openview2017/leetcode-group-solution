public class main0464 {
    public static void main(String[] args) {
        Solution0464 sol = new Solution0464();
        int max; int target; boolean res;
        max = 10;
        target = 11;
        res = sol.canIWin(max, target);
        System.out.println(res);

        max = 10;
        target=0;
        res = sol.canIWin(max, target);
        System.out.println(res);

        max = 10;
        target=1;
        res = sol.canIWin(max, target);
        System.out.println(res);
    }
}

class Solution0464 { // 02 - 06
    public boolean canIWin(int max, int target) {
        if (target <= max) {
            return true;
        }
        if (max*(max+1)/2 < target) {
            return false;
        }
        Boolean[] dp = new Boolean[1<<max+1];
        return dfs(dp, 0, max, target);
    }
    
    private boolean dfs(Boolean[] dp, int bm, int max, int target) {
        if (target <= 0) return false;
        if (dp[bm] != null) return dp[bm];
        boolean flag = false;
        for (int i = 1; i <= max; i++) {
            if ((bm & (1<<(i-1))) == 0) {
                flag = flag || !dfs(dp, bm | (1<<(i-1)), max, target - i);
            }
        }
        dp[bm] = flag;
        return dp[bm];
    }
}