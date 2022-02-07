/*
TC: O(n) left to right, right to left, twice
SC: O(n) for the stringbuilder
*/

class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        char[] input = s.toCharArray();
        
        // step 1: from left to right, identify the 多的左括号，标成0
        int count= 0;
        for (int i = 0; i < n; i++) {
            if (input[i] == '(') {
                count++;
            } else if (input[i] == ')') {
                if (count > 0) {
                    count--;
                } else {
                    input[i] = 0;
                }
            }
        }
         // step 2: from right to left, identify the 多的右括号，标成0
        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (input[i] == ')') {
                count++;
            } else if (input[i] == '(') {
                if (count > 0) {
                    count--;
                } else {
                    input[i] = 0;
                }
            }
        }
        // step 3: 最后把答案组装一下，跳过0
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (input[i] != 0) {
                sb.append(input[i]);
            }
        }
        return sb.toString();
    }
}
