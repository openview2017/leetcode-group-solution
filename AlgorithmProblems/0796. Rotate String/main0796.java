public class main0796 {
    public static void main(String[] args) {
        Solution0796 sol = new Solution0796();
        String s, goal;
        boolean res;

        s = "abcde"; goal = "cdeab";
        res = sol.rotateString(s, goal);
        System.out.println(res);
    }
}

class Solution0796 { // 00 - 03
    public boolean rotateString(String s, String goal) {
        char f = goal.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == f) {
                String tmp = s.substring(i) + s.substring(0,i);
                if (tmp.equals(goal)) {
                    return true;
                }
            }
        }
        return false;
    }
}
