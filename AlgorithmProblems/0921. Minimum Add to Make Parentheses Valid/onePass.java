/*
从左到右只需要走一边，分别记录多余的左括号的个数和多余的右括号的个数，最后的答案是加起来。
TC: O(n)
SC: O(1)

*/
class Solution {
    public int minAddToMakeValid(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        
        int countLeft = 0;
        int countRight = 0;

        // left to right
        for (int i = 0; i < n; i++) {
            char cur = array[i];
            if (cur == '(') {
                countLeft++;
            } else if (cur == ')') {
                if (countLeft > 0) {
                    countLeft--;
                } else {
                    countRight++;
                }
            }
        }
        
        return countLeft + countRight;
    }
}

