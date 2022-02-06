/*
522. Longest Uncommon Subsequence II
Medium

Given an array of strings strs, return the length of the longest uncommon subsequence between them. If the longest uncommon subsequence does not exist, return -1.

An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.

A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.

For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc". Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).
 

Example 1:

Input: strs = ["aba","cdc","eae"]
Output: 3
Example 2:

Input: strs = ["aaa","aaa","aa"]
Output: -1
 

Constraints:

2 <= strs.length <= 50
1 <= strs[i].length <= 10
strs[i] consists of lowercase English letters.


*/
/* explain https://leetcode-cn.com/problems/longest-uncommon-subsequence-ii/solution/zui-chang-te-shu-xu-lie-ii-by-leetcode/
tc: o(nlogn + n^2 + o(n^2))
sc: o(1)

Method 2 pointer in checking isSubsequence

*/
import java.util.*;

public class main0522 {
    public static void main(String[] args) {
        Solution0522 sol = new Solution0522();
        String[] strs;
        int res;
    
        strs = new String[]{"aba","cdc","eae"};
        System.out.println(Arrays.deepToString(strs));
        res = sol.findLUSlength(strs);
        System.out.println(res);
            
        strs = new String[]{"aaa","aaa","aa"};
        System.out.println(Arrays.deepToString(strs));
        res = sol.findLUSlength(strs);
        System.out.println(res);
    }
}


class Solution0522 { //05 -28
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());
        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) { // cannot j=i+1, then may not go into 2nd for -> cause wrong answer.
                if (i == j) continue;
                if (isSubseq(strs[i], strs[j])) {
                    flag = false;
                    //System.out.println(i + "," + j + "," + flag);
                    break;
                }
            }
            if (flag) {
                return strs[i].length();
            }
        }
        return -1;
    }
    
    private boolean isSubseq(String str1, String str2) { // str1 shorter
        if (str1.length() > str2.length()) {
            return false;
        }
        int i1 = 0, i2 = 0;
        for (i2 = 0; i2 < str2.length(); i2++) {
            if (i1 < str1.length()) {
                if (str1.charAt(i1) == str2.charAt(i2)) {
                    i1++;
                }
            } else {
                break;
            }
        }
        return i1 == str1.length();
    }
}

