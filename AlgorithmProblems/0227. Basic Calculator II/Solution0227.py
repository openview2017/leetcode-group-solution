class Solution0227:
    def calculate0(self, s: str) -> int:
        if s == None or len(s) == 0:
            return 0
        stack, num, res = [], 0, 0
        sign = '+'
        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            if s[i] in '+-*/' or i == len(s) - 1:
                if sign == '+':
                    stack.append(num)
                elif sign == '-':
                    stack.append(-num)
                elif sign == '*':
                    stack.append(stack.pop() * num)
                elif sign == '/':
                    stack.append(int(stack.pop() / num))
                num = 0
                sign = s[i]
                
        return sum(stack)


    def calculate(self, s: str) -> int:
        if s == None or len(s) == 0:
            return 0
        last, cur, res = 0, 0, 0
        sign = '+'
        for i in range(len(s)):
            if s[i].isdigit():
                cur = cur * 10 + int(s[i])
            if s[i] in '+-*/' or i == len(s) - 1:
                if sign == '+':
                    res += last
                    last = cur
                elif sign == '-':
                    res += last
                    last = -cur
                elif sign == '*':
                    last *= cur
                elif sign == '/':
                    last = int(last / cur)
                cur = 0
                sign = s[i]

        return last + res  

sol = Solution0227()
s="3+2*2"
ans = sol.calculate(s)
print(s + "=" + str(ans))
s=" 3/2 "
ans = sol.calculate(s)
print(s + "=" + str(ans))
s=" 3+5 / 2 "
ans = sol.calculate(s)
print(s + "=" + str(ans))