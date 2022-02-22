public class main0777 {
    public static void main(String[] args) {
        Solution0777 sol = new Solution0777();
        String start, end;
        boolean res;

        start = "RXXLRXRXL"; end = "XRLXXRRLX";
        res = sol.canTransform(start, end);
        System.out.println("start: " + start + ", " + "end:" + end);
        System.out.println(res);
    }
}

class Solution0777 {
    public boolean canTransform(String start, String end) {
        
        int i = 0, sLen = start.length();
        int j = 0, eLen = end.length();
        //char schar, echar;
        // char[] s = start.toCharArray();
        // char[] e = end.toCharArray();
        
        while (i < sLen || j < eLen)
        {
            // stop at char that is not 'X'
            while (i < sLen && start.charAt(i) == 'X') { i++; }
            while (j < eLen && end.charAt(j) == 'X') { j++; }
            
            if (i >= sLen || j >= eLen) { break; }
            
            // relative order for 'R' and 'L' in 2 strings should be the same
            if (start.charAt(i) != end.charAt(j)) { return false; }
            // R can only move to right
            if (start.charAt(i) == 'R' && i > j) { return false; } // i<= j && (i = j - 1 || i == j) -> 
            // L can only move to left
            if (start.charAt(i) == 'L' && i < j) { return false; }
            
            // check next
            i++;
            j++;
        }
        
        return i == j;
    } 
}
