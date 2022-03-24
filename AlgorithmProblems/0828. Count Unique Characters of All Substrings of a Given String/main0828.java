/*
Example 1:

Input: s = "ABC"
Output: 10
Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
Evey substring is composed with only unique letters.
Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
Example 2:

Input: s = "ABA"
Output: 8
Explanation: The same as example 1, except countUniqueChars("ABA") = 1.
Example 3:

Input: s = "LEETCODE"
Output: 92
*/

public class main0828 {
    public static void main(String[] args) {
        Solution0828 sol = new Solution0828();
        String s;
        int res;

        s = "ABC";
        res = sol.uniqueLetterString(s);
        System.out.println(s + ": " + res);

        
        s = "ABA";
        res = sol.uniqueLetterString(s);
        System.out.println(s + ": " + res);

        
        s = "LEETCODE";
        res = sol.uniqueLetterString(s);
        System.out.println(s + ": " + res);
    }
}

class Solution0828 {
	private static final char A = 'A';
	private int M = (int) 1e9 + 7;

	public int uniqueLetterString(String s) {
		int len = s.length();
		char[] chars = s.toCharArray();
		int[][] dic = new int[26][2];
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 2; j++) {
				dic[i][j] = -1;// 结算dic[cur][1]位置，只包含dic[cur][1]位置字符的子串数量。初始为-1，便于判断是否出现和结算只出现1次的字符
			}
		}
		int ans = 0;
		for (int i = 0; i < len; i++) {
			int cur = chars[i] - A;
			if (dic[cur][1] == -1) {// 第一次出现的字符给dic[cur][1];
				dic[cur][1] = i;
			} else {
				int num = (dic[cur][1] - dic[cur][0]) * (i - dic[cur][1]);// 子串只包含dic[cur][1]位置字符的数量
				ans = (ans + num + M) % M;// 累和
				dic[cur][0] = dic[cur][1];// 计算过的dic[cur][1]变成左边界
				dic[cur][1] = i;// 当前i变成下一个结算的位置
			}
		}
		for (int cur = 0; cur < 26; cur++) {// 跳出第一个for没有被结算到的位置，用len结算
			if (dic[cur][1] != -1) {
				int num = (dic[cur][1] - dic[cur][0]) * (len - dic[cur][1]);
				ans = (ans + num + M) % M;
			}
		}
		return ans;
	}
}

/*作者：wa-pian-d
中心开花-》 找到左右第一个相同的字母 -》左右长度乘积就是含中心字母的substring
链接：https://leetcode-cn.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/solution/wa-pian-828-tong-ji-zi-chuan-zhong-de-we-2pj6/
来源：力扣（LeetCode）
TC:o(n), sc:o(1)
*/