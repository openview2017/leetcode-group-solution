/*
step 1: remove spaces
step 2: reverse overall
step 3: reverse each word

TC: O(n)
SC: O(1)
*/
class Solution56 {
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        int slow = 0; // 0..slow - 1 to keep*
        for (int i = 0; i < array.length; i++) { // fast pointer
            char cur = array[i];
            if (cur != ' ') {
                array[slow++] = cur;
            } else if (i >= 1 && array[i - 1] != ' ') {
                array[slow++] = cur;
            }
        }
        if (slow - 1 < array.length && array[slow - 1] == ' ') { //1. 这里是slow-1，不是slow
            slow--;
        }
        
        
        int start = 0;
        int end = 0;
        for (int i = 0; i < slow; i++) {
            if (i == 0 || array[i - 1] == ' ') {
                start = i;
            }
            if (i == slow - 1 || array[i + 1] == ' ') {
                end = i;
                reverse(array, start, end);
            }
        }
        reverse(array, 0, slow - 1);
        return new String(array, 0, slow);
    }
    private void reverse(char[] array, int start, int end) {
        while (start < end) { // 2.
            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;    
            start++;
            end--;
        }

    }
}