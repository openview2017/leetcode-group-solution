package Calculator;

import java.util.*;

/**
 * Created by yingli on 4/26/22.
 */

/*
link : https://www.1point3acres.com/bbs/thread-830803-1-1.html
* Reference : LC 772 https://leetcode.com/problems/basic-calculator-iii/
*
* Question1 : input String : "three times negative five"
*
* Question2: with parameter
*
*Operation : add, times,
* */

/*
* Assume !!!! all the number is within 1 to 20
*
* */
public class Calculator {

    public static void main(String[] args) {

        Calculator test = new Calculator();
        System.out.println("Test 1 : " + test.calculator("ten add four times negative two add ten minus negative five"));
        System.out.println("Test 2 : " + test.calculator("Two add three times negative two"));
    }

    Set<String> operation = new HashSet<>(Arrays.asList("add", "minus", "times", "divide", "negative"));
    Map<String, Integer> numbers = new HashMap<String, Integer>() {
        {
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
            put("ten", 10);
        }
    };

    public int calculator(String str) {
        if (str == null || str.length() == 0) return 0;

        //assume each word separated by a space, otherwise we need a function to parse string into a list of words
        //String[] words = parseString(str);
        str = str + " add zero";
        String[] words = str.split(" ");
        Deque<Integer> stack = new ArrayDeque<>();
        String preOperation = "add";
        int sign = 1;
        int num = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            if (numbers.containsKey(word)) {
                num = sign * numbers.get(word);
                System.out.println("number to add to stack : " + num);
            } else
            if (word.equals("negative")) {
                sign = -1;
                continue;
            } else
            if (operation.contains(word)) {
                if (preOperation.equals("add")) {
                    stack.push(num);
                } else if (preOperation.equals("minus")) {
                    stack.push(-num);
                } else if (preOperation.equals("times")) {
                    stack.push(stack.pop()  * num);
                } else if (preOperation.equals("divide")) {
                    stack.push(stack.pop() / num);
                }
                preOperation = word;
                sign = 1;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;


    }
}
