import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main s = new Main();
        int res = s.findPasswordStrength("hackerrank");
        System.out.println(res);
    }
    public int findPasswordStrength(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        
        List<String> cur = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(s, 0, cur, res);
        int maxCount = 0;
        for (Integer num : res) {
            maxCount = Math.max(maxCount, num);
        }
        return maxCount;
    }
    
    // DFS, TC
    private void helper(String s, int index, List<String> cur, List<Integer> res) {
        if (index == s.length()) {
            res.add(cur.size());
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (isValid(sub)) {
                cur.add(sub);
                helper(s, i + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
    // 
    private boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        boolean hasV = false;
        boolean hasC = false;
        for (char c : s.toCharArray()) {
            if (c == 'a' ||c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                hasV = true;
            } else {
                hasC = true;
            }
            if (hasV && hasC) {
                return true;
            }
        }
        return false;
    }
}