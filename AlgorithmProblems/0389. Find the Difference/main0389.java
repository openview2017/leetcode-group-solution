public class main0389 {
    public static void main(String[] args) {
        Solution0389 sol = new Solution0389();
        String s, t;
        char res;

        s = "abcd";
        t = "abcde";
        res = sol.findTheDifference(s, t);
        System.out.println(res);
    }
}

class Solution0389 {
    public char findTheDifference(String s, String t) {
        char c = 0;
        for (char a : s.toCharArray()) {
            c ^= a;
        }
        for (char a : t.toCharArray()) {
            c ^= a;
        }
        return c;
    }
}