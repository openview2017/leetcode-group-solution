class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>(); //stack里面装了不合适的括号的index
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                    st.push(i);
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty() && s.charAt(st.peek()) == '(') {
                    st.pop();
                } else {
                    st.push(i);
                }
            }
            sb.append(s.charAt(i)); //所有的元素都要append
        }
            
        while (!st.isEmpty()) {
            sb.deleteCharAt(st.pop()); // 从后面开始pop，按stringbuilder的位置从后往前来删
        }
        
        return sb.toString();
    }
}

/*
Runtime: 32 ms, faster than 38.97% of Java online submissions for Minimum Remove to Make Valid Parentheses.
Memory Usage: 42.6 MB, less than 56.89% of Java online submissions for Minimum Remove to Make Valid Parentheses.
TC: O(n) for the initial traversal, and also for the StringBuilder operations
SC: O(n) for the stack
*/