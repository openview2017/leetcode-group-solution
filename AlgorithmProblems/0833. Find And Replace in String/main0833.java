/*
833. Find And Replace in String
Medium

You are given a 0-indexed string s that you must perform k replacement operations on. The replacement operations are given as three 0-indexed parallel arrays, indices, sources, and targets, all of length k.

To complete the ith replacement operation:

Check if the substring sources[i] occurs at index indices[i] in the original string s.
If it does not occur, do nothing.
Otherwise if it does occur, replace that substring with targets[i].
For example, if s = "abcd", indices[i] = 0, sources[i] = "ab", and targets[i] = "eee", then the result of this replacement will be "eeecd".

All replacement operations must occur simultaneously, meaning the replacement operations should not affect the indexing of each other. The testcases will be generated such that the replacements will not overlap.

For example, a testcase with s = "abc", indices = [0, 1], and sources = ["ab","bc"] will not be generated because the "ab" and "bc" replacements overlap.
Return the resulting string after performing all replacement operations on s.

A substring is a contiguous sequence of characters in a string.

 

Example 1:


Input: s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]
Output: "eeebffff"
Explanation:
"a" occurs at index 0 in s, so we replace it with "eee".
"cd" occurs at index 2 in s, so we replace it with "ffff".

Constraints:

1 <= s.length <= 1000
k == indices.length == sources.length == targets.length
1 <= k <= 100
0 <= indexes[i] < s.length
1 <= sources[i].length, targets[i].length <= 50
s consists of only lowercase English letters.
sources[i] and targets[i] consist of only lowercase English letters.
*/

import java.util.Arrays;

public class main0833 {
    public static void main(String[] args) {
        Solution0833 sol = new Solution0833();
        String s, res;
        String[] targets, sources;
        int[] indices;

        s = "abcd";
        indices = new int[]{0, 2};
        sources = new String[]{"a", "cd"};
        targets = new String[]{"eee", "ffff"};
        res = sol.findReplaceString(s, indices, sources, targets);
        System.out.println(s);
        System.out.println(Arrays.toString(indices));
        System.out.println(Arrays.toString(sources));
        System.out.println(Arrays.toString(targets));
        System.out.println(res);

    }
}


class Solution0833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int[] mark = new int[s.length()];
        Arrays.fill(mark, -1);
        int j = 0; // s pointr
        for (int i = 0; i < indices.length; i++) {
            //System.out.println(s.substring(indices[i], indices[i]+sources[i].length()));
            if (s.substring(indices[i], indices[i]+sources[i].length()).equals(sources[i])) {
                mark[indices[i]] = i;
            }
        }
        //System.out.println(Arrays.toString(mark));
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (mark[i] != -1) {
                sb.append(targets[mark[i]]);
                i += sources[mark[i]].length();
            } else {
                sb.append(s.charAt(i++));
            }
        }
        
        return sb.toString();
    }
}

/*
c:
@parameter: s, indicies, source, targets
@assumption
@ 1. change of replace string

Method, int[] array - s.length(), s[i] location at i, index of indicies
                 |
    0  1  2    3  
    a, b, c,   d
map 0  -1 1   -1

key: indicies[i]  0  2
value: i          0  1

sb:eee b ffff  

tc: o(n)

1. for loop indices  - tc: length of source - m * (L)
    a. match
    b. mark index array with index in indicies
2. reconstruct
  tc: O(n + m*L(t))

*/