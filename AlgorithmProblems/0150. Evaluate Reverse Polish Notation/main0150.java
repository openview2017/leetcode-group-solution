public class main0150 {
    
}


class Solution0150 { 
    public int evalRPN(String[] tokens) {
        Deque<String> ops = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        Set<String> opSet = Set.of("+","-","*","/");
        for (String token : tokens) {
            if (!opSet.contains(token)) {
                nums.offerLast(Integer.parseInt(token));
            } else {
                nums.offerLast(calc(nums.pollLast(), nums.pollLast(), token));
            }
        }
        return nums.peekLast();
    }
    
    private int calc(int num2, int num1, String op) {
        switch(op) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2;
        }
        throw new IllegalArgumentException();
    }
}