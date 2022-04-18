import java.util.Arrays;

// method 2 pointer, tc: o(n), sc: o(1)
// two pointer point to target char, calc distance to left and right;

public class main0821 {
    public static void main(String[] args) {
        String s;
        char c;
        int[] res;
        Solution0821 sol = new Solution0821();
        
        s = "loveleetcode";
        c = 'e';
        res = sol.shortestToChar(s, c);
        System.out.println("Input string : " + s + "," + "Character: " + c);
        System.out.println(Arrays.toString(res)); 
                
        s = "aaab";
        c = 'b';
        res = sol.shortestToChar(s, c);
        System.out.println("Input string : " + s + "," + "Character: " + c);
        System.out.println(Arrays.toString(res)); 
    }
}

class Solution0821 {
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int p0 = -1, p1 = -1; // s[p0] == c, s[p1] == c
        int dist0 = Integer.MAX_VALUE, dist1 = Integer.MAX_VALUE;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (i > p1) {
                p0 = p1;
                p1 = p0 + 1;
                while (p1 < len && s.charAt(p1) != c) {
                    p1++;
                }
            }
            dist0 = (p0 == -1) ? Integer.MAX_VALUE : i - p0;
            dist1 = (p1 == len) ? Integer.MAX_VALUE : p1 - i; 
            res[i] = Math.min(dist0, dist1);
        }
        return res;
    }

    public int[] shortestToChar2(String S, char C) { // two round scan, record the prev c location
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }
}

/*abstract
821. Shortest Distance to a Character
Easy

2053

121

Add to List

Share
Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.

The distance between two indices i and j is abs(i - j), where abs is the absolute value function.

 

Example 1:

Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
Example 2:

Input: s = "aaab", c = "b"
Output: [3,2,1,0]
 

Constraints:

1 <= s.length <= 104
s[i] and c are lowercase English letters.
It is guaranteed that c occurs at least once in s.
*/