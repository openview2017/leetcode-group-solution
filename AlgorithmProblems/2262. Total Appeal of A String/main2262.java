import java.util.Arrays;

public class main2262 {
    public static void main(String[] args) {
        Solution2262 sol = new Solution2262();
        String s;
        long res;
        s = "abbca";
        res = sol.appealSum(s);
        System.out.println(res);
    }
}


class Solution2262 {
    public long appealSum(String s) {
        int[] last = new int[26];
        Arrays.fill(last, -1);
        long tot = 0;
        int curApp = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            curApp += (i - last[cur]);
            tot += curApp;
            last[cur] = i; // !!!
        }
        return tot;
    }
}
// https://leetcode.cn/problems/total-appeal-of-a-string/solution/by-endlesscheng-g405/