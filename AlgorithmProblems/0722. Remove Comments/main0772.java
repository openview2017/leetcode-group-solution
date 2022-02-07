import java.util.*;

public class main0772 {
    public static void main(String[] args) {
        Solution0772 sol = new Solution0772();
        String[] source;
        List<String> res;

        source = new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        res = sol.removeComments(source);
        System.out.println(Arrays.toString(source));
        System.out.println(Arrays.toString(res.toArray()));

        source = new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        res = sol.removeComments(source);
        System.out.println(Arrays.toString(source));
        System.out.println(Arrays.toString(res.toArray()));
    }
}

class Solution0772 {
    public List<String> removeComments(String[] source) {
        boolean inBlock = false;
        StringBuilder newline = new StringBuilder();
        List<String> ans = new ArrayList();
        for (String line: source) {
            int i = 0;
            char[] chars = line.toCharArray();
            if (!inBlock) newline = new StringBuilder();
            while (i < line.length()) {
                if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
                    break;
                } else if (!inBlock) {
                    newline.append(chars[i]);
                }
                i++;
            }
            if (!inBlock && newline.length() > 0) {
                ans.add(new String(newline));
            }
        }
        return ans;
    }

// 链接：https://leetcode-cn.com/problems/remove-comments/solution/shan-chu-zhu-shi-by-leetcode/
public List<String> removeComments0(String[] source) { // practice
    List<String> res = new ArrayList<>();
    boolean inComment = false;
    StringBuilder cur = new StringBuilder();
    for (String str : source) {
        if (!inComment) {
            cur = new StringBuilder();                
        }
        char[] tmp = str.toCharArray();
        for (int i = 0; i < tmp.length; i++) {
            if (i < tmp.length - 1 && !inComment && tmp[i] == '/' && tmp[i+1] == '*') {
                inComment = true;
                i++; // !!!!!!
            } else if (i < tmp.length - 1 && inComment && tmp[i] == '*' && tmp[i+1] == '/'){
                inComment = false; 
                i++; // !!!!!!
            } else if (!inComment && i < tmp.length - 1 && tmp[i] == '/' && tmp[i+1] == '/') {
                break;
            } else if (!inComment) {
                cur.append(tmp[i]);
            }
        }
        if (cur.length() > 0 && !inComment) res.add(cur.toString()); // !inComment !!!!!!!!!
    }
    return res;
}
}

