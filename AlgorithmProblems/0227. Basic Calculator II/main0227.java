public class main0227 {
    public static void main(String[] args) {
        Solution0227 sol = new Solution0227();
        String s;
        int res;

        s = "3+2*2";
        res = sol.calculate(s);
        System.out.println(res);
    }
}


class Solution0227 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int cur = 0;
        int last = 0;
        int res = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char curChar = s.charAt(i);
            if (Character.isDigit(curChar)) {
                cur = (cur * 10) + (curChar - '0');
            }
            if (!Character.isDigit(curChar) && !Character.isWhitespace(curChar) || i == len - 1) {
                if (operation == '+' || operation == '-') {
                    res += last;
                    last = (operation == '+') ? cur : - cur;
                } else if (operation == '*') {
                    last = last * cur;
                } else if (operation == '/') {
                    last = last / cur;
                }
                operation = curChar;
                cur = 0;            
            }
        }
        res += last;
        return res;
    }
}