/*
left to right: identify extra )
right to left: identify extra (

TC: O(n)
SC: O(1)

*/

class Solution {
    public int minAddToMakeValid(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        
        int countLeft = 0;
        int countRight = 0;
        
        int res = 0;

        // left to right
        for (int i = 0; i < n; i++) {
            char cur = array[i];
            if (cur == '(') {
                countLeft++;
            } else if (cur == ')') {
                if (countLeft > 0) {
                    countLeft--;
                } else {
                    res++;
                }
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            char cur = array[i];
            if (cur == ')') {
                countRight++;
            } else if (cur == '(') {
                if (countRight > 0) {
                    countRight--;
                } else {
                    res++;
                }
            }
        }
        
        return res;
    }
}