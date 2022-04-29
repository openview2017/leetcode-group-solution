/*
使用stack来记录目前为止多出来的左括号, stack里放左括号对应的右括号，后面就可以直接对比了。
TC: O(n) where n is the input length
SC: O(n) up to n

*/
class Solution {
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            char cur = array[i];
            if (cur == '(') {
                stack.offerFirst(')');
            } else if (cur == '{') {
                stack.offerFirst('}');
            } else if (cur == '[') {
                stack.offerFirst(']');
            } else if (stack.isEmpty()) {
                return false;
            } else if (stack.peekFirst() != cur) {
                return false;
            } else {
                stack.pollFirst();
            }
        }
        return stack.isEmpty();
    }
}