public class main0984 {
    public static void main(String[] args) {
        Solution0984 sol = new Solution0984();
        int a, b;
        String res;

        a = 1; b = 2;
        res = sol.strWithout3a3b(a, b);
        System.out.println("a, b :" + a + ", " + b);
        System.out.println(res);

        a = 4; b = 1;
        res = sol.strWithout3a3b(a, b);
        System.out.println("a, b :" + a + ", " + b);
        System.out.println(res);        
    }
}

class Solution0984 { // tc: o(a+b), sc: o(1)
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (a + b > 0) {
            if (i > 1 && sb.charAt(i-1) == sb.charAt(i-2)) {
                if (sb.charAt(i-1) == 'a') {
                    sb.append('b'); b--;
                } else {
                    sb.append('a'); a--;
                }
            } else {
                if (a > b) {
                    sb.append('a'); a--;               
                } else {
                    sb.append('b'); b--;
                }
            }
            i++;
        }
        return sb.toString();
    }
}
// ref: https://leetcode.com/problems/string-without-aaa-or-bbb/discuss/226648/Java-straightforward