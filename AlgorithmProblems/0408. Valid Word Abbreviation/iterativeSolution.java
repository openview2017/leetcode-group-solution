/*
iterative的方法
TC: O(m + n)
SC: O(1)

注意：如果遇到数字，马上加一个while loop，把所有的数字当轮看完。
*/
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0; 
        int j = 0;

        while (i < word.length() && j < abbr.length()) {
            
            char c = abbr.charAt(j);
            if (c >= 'a' && c <= 'z') {
                if (word.charAt(i) != c) {
                    return false;
                }
                i++;
                j++;
            } else if (c == '0') { // 单独加一个leading 0是不valid的判断
                return false;
            } else if (c > '0' && c <= '9') {
                int num = 0;
                //这里加一个while，就不需要使用外面的while来推进了
                while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                    num = num * 10 + abbr.charAt(j) - '0';
                    j++;
                }
                i = i + num;
               // j++;
               
            } 
        }
        return i == word.length() && j == abbr.length();
    }
}