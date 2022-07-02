from typing import List


class Solution0150:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            if token not in "+-*/":
                stack.append(int(token))
                continue
                
            num2 = stack.pop()            
            num1 = stack.pop()
            tmp = 0
            if token == "+":
                tmp = num1 + num2
            elif token == "-":
                tmp = num1 - num2
            elif token == "*":
                tmp = num1 * num2
            else:
                tmp = int(num1 / num2)
                
            stack.append(tmp)
            
        return stack.pop()