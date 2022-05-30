public class main0696 {
    public static void main(String[] args) {
        Solution0696 sol = new Solution0696();
        
    }
}

class Solution0696 {
    public int countBinarySubstrings(String s) {
        int res = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i-1)) {
                res += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return res + Math.min(prev, cur);
    }
}