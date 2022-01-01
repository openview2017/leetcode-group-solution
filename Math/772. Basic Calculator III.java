import java.util.*;

public class Solution {

	public int calculate(String s) {
		Stack<Integer> numStack = new Stack<>();
		Stack<Character> opStack = new Stack<>();
		int n = s.length();

		HashMap<Character, Integer> PRMap = new HashMap<Character, Integer>() {
			{
				put('(', 0);
				put(')', 0);
				put('+', 1);
				put('-', 1);
				put('*', 2);
				put('/', 2);
			}
		};

		s = preprocess(s);

		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				int val = Character.getNumericValue(ch);
				while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
					val = val * 10 + Character.getNumericValue(s.charAt(i + 1));
					i++;
				}
				numStack.push(val);
			} else if (ch == '(') {
				opStack.push(ch);
			} else if (ch == ')') {
				while (!opStack.isEmpty() && opStack.peek() != '(') {
					calcTwoNum(numStack, opStack);
				}
				opStack.pop(); // pop the left '('
			} else if ("+-*/".contains(String.valueOf(ch))) {
				while (!opStack.isEmpty() && PRMap.get(ch) <= PRMap.get(opStack.peek())) {
					calcTwoNum(numStack, opStack);
				}
				opStack.push(ch);
			}
		}
		while (!opStack.isEmpty()) {
			calcTwoNum(numStack, opStack);
		}
		return numStack.pop();
	}

	private String preprocess(String s) {
		StringBuilder ans = new StringBuilder();
		if (s.charAt(0) == '-') {
			ans.append('0');
		}
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isWhitespace(ch))
				continue;
			if (ch == '(' && s.charAt(i + 1) == '-') {
				ans.append(ch);
				ans.append('0');
				ans.append(s.charAt(i + 1));
			} else {
				ans.append(ch);
			}
		}
		String res = ans.toString();
		return res;
	}

	private void calcTwoNum(Stack<Integer> numStack, Stack<Character> opStack) {
		int y = numStack.pop();
		int x = numStack.pop();
		char op = opStack.pop();
		if (op == '+')
			numStack.push(x + y);
		if (op == '-')
			numStack.push(x - y);
		if (op == '*')
			numStack.push(x * y);
		if (op == '/')
			numStack.push(x / y);
	}
}
