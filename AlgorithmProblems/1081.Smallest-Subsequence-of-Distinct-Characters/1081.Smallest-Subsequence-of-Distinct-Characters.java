//TBD
class Solution {
    public String smallestSubsequence(String s) {
        if (s == null || s.length() == 0) return null;
        Map<Character, Integer> lastPositionMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastPositionMap.put(s.charAt(i), i);
        }
        Deque<Character> stack = new ArrayDeque<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //condider if unique
            if (!set.contains(c)) {
                //keep pop/remove when peek char is larger than current, for lexicographically smallest
                //keep pop/remove when peek char last position is larger than current , that means we will meet it again later
                while (!stack.isEmpty() && stack.peek() >= c && lastPositionMap.get(stack.peek()) >= i) {
                    set.remove(stack.pop());
                }
                stack.push(c);
                set.add(c);
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}