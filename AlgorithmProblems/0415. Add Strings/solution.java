/*
经典大数加法
从后往前加，列竖式
和Add two number很想
*/

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int c = 0;
        
        while (i >= 0 || j >= 0 || c > 0) { // 1. 这里是｜｜而不是&&
            if (i >= 0) { 
                c += num1.charAt(i) - '0';
                i--; // 4. i--
            }
            if (j >= 0) {  // 2. 2个if之间并没有else的关系
                c += num2.charAt(j) - '0';
                j--;
            }
            sb.append(c % 10);
            c = c / 10;
        }
        return sb.reverse().toString(); // 3. 最后stringbuilder反过来
    }
}