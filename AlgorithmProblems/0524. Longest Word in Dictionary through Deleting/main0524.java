/*
524. Longest Word in Dictionary through Deleting
Medium

Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

 

Example 1:

Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"
Example 2:

Input: s = "abpcplea", dictionary = ["a","b","c"]
Output: "a"
 

Constraints:

1 <= s.length <= 1000
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 1000
s and dictionary[i] consist of lowercase English letters.

*/

import java.util.*;

public class main0524 {
    public static void main(String[] args) {
        Solution0524 sol = new Solution0524();
        String s, res;
        String[] strs;
    
        s = "abpcplea";
        strs = new String[]{"ale","apple","monkey","plea"};
        System.out.println(s + "," + Arrays.deepToString(strs));
        res = sol.findLongestWord(s, strs);
        System.out.println(res);
            
        s = "abpcplea";
        strs = new String[]{"a","b","c"};
        System.out.println(s + "," + Arrays.deepToString(strs));
        res = sol.findLongestWord(s, strs);
        System.out.println(res);
}

public class Solution0524 { // without sorting, everystep compare, tc: o(n*avg(L)), SC:o(maxLength)
    public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }
    public String findLongestWord(String s, String[] strs) {
        String max_str = "";
        for (String str: strs) {
            if (isSubsequence(str, s)) {
                if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0))
                    max_str = str;
            }
        }
        return max_str;
    }
}