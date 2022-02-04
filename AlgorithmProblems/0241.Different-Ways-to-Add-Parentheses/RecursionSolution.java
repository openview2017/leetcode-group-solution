/*
how many levels? what does each level mean? number of operator levels, each level is an operator 
how many branches in each level? number of operator branches
TC: O(m^m) where m is the number of operators in the input
SC: O(m)


*/
class Solution {
    //物理意义：给一个input，给这个input的所有可能的值
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char cur = expression.charAt(i);
            if (cur == '+' || cur == '-' || cur == '*') {
                List<Integer> part1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> part2 = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                
                for (Integer one : part1) {
                    for (Integer two : part2) {
                        int c = 0;
                        if (cur == '-') {
                            c = one - two;
                        } else if (cur == '+') {
                            c = one + two;
                        } else if (cur == '*') {
                            c = one * two;
                        }
                        res.add(c);
                    }
                }
            }
        }
        // 没有操作符，只有数字，直接把数字加到res里面
        if (res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }
        return res;
    }
}