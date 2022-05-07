public class main0389 {
    
}

class Solution {
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