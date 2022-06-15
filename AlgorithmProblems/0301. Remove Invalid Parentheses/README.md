# 301. Remove Invalid Parentheses

[301. Remove Invalid Parentheses - LeetCode](https://leetcode.com/problems/remove-invalid-parentheses/)

- input: `String s` 一个括号序列

- output：`List<String>` 修改这个序列，使其合法。
  - 只能进行删除操作，
  - 进行最少次删除

eg.

```
Input: s = "()())()"
Output: ["(())()","()()()"]
```
```
Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]
```
---

*Fei Huang - June 10 2022*

[Remove Invalid Parentheses - Submission Detail - LeetCode](https://leetcode.com/submissions/detail/520865386/)

```java
class Solution:
    """
    s = "(a)((((()"
    find the bracket that need to delete
               (a)((((()
                /       \           \ 
              a)((((()  (a((((()   (a)(((() ....
    get new string, validate
    """
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if s == None:
            return [""]
        
        left_del, right_del = self.findparenthesesCount(s)
 #       print(left_del, right_del)
        if left_del == 0 and right_del == 0:
            return [s]
        ans = []
        visited = [False] * len(s)
        self.removeInvalidParentheseshelper(s, 0, left_del, right_del, ans, visited)
        if ans == []:
            return ['']
        return ans

    def removeInvalidParentheseshelper(self, s, start, left_del, right_del, ans, visited):
        if left_del < 0 or right_del < 0:
            return
        if left_del == 0 and right_del == 0:
            strpath = ''
            for i in range(len(visited)):
                if visited [i] == False:
                    strpath += s[i]
            if self.check(strpath):
                ans.append(strpath)
            return
        for i in range(start, len(s)):
            if s[i] not in '()':
                continue
            if i > 0 and s[i] == s[i - 1] and not visited[i - 1]:
                continue
                
            if s[i] == "(":
                visited[i] = True
                self.removeInvalidParentheseshelper(s, i + 1, left_del - 1, right_del, ans, visited)        
                visited[i] = False
            elif s[i] ==')':
                visited[i] = True
                self.removeInvalidParentheseshelper(s, i + 1, left_del, right_del - 1, ans, visited)        
                visited[i] = False
                      
    def findparenthesesCount(self,s):
        indicator, right_del = 0, 0     
        for i in range(len(s)):
            char = s[i]
            if char == "(":
                indicator += 1
            elif char == ")":
                indicator -= 1
                if indicator == -1:
                    right_del += 1
                    indicator = 0
              
        return indicator, right_del
    
    def check(self,s):
        indicator = 0   
        for i in range(len(s)):
            char = s[i]
            if char == "(":
                indicator += 1
                continue
            if char == ")":
                indicator -= 1
                if indicator == -1:
                    return False
        if indicator !=0:
            return False
        return True
```

---

*Jiaqian Wu - Feb 19 2022*

```python
from typing import List
"""
1. Count how many left parentheses and right parentheses to remove.
2. Count how many left parentheses and right parentheses to keep.
3. DFS to solve. 
4. `idx` is a pointer indicate which character in s we are currently using.
5. We can either pick this idx character or skip it. If it's not '(' or ')' we must take it.
6. Each time we pick a '(', left = left - 1. ')' => right = right-1
7. left always less than or equal to right and left always greater than or equal to 0.
8. If idx == len(s) and we use all left and right. Add current string to result.

Time complexity: O(2^N)
Space complexity: O(N)
"""

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        left = self.countLeft(s)
        right = self.countRight(s)
        result = set()
        self.dfs(s, 0, left, right, [], result)
        return result
        
    def dfs(self, s, idx, left, right, path, result):
        if idx == len(s):
            if left == right == 0:
                result.add("".join(path))
            return
        if s[idx] != "(" and s[idx] != ")":
            path.append(s[idx])
            self.dfs(s, idx+1, left, right, path, result)
            path.pop()
            return
        if s[idx] == "(" and left > 0:
            path.append("(")
            self.dfs(s, idx+1, left-1, right, path, result)
            path.pop()
        if s[idx] == ")" and right > left:
            path.append(")")
            self.dfs(s, idx+1, left, right-1, path, result)
            path.pop()
        self.dfs(s, idx+1, left, right, path, result)
        return
        
        return
    def countRight(self, s):
        cur_left = 0
        total_right = 0
        right_to_remove = 0
        for i in s:
            if i == "(":
                cur_left += 1
            elif i == ")":
                total_right += 1
                if cur_left == 0:
                    right_to_remove += 1
                else:
                    cur_left -= 1
        return total_right - right_to_remove
    
    def countLeft(self, s):
        cur_right = 0
        total_left = 0
        left_to_remove = 0
        for i in s[::-1]:
            if i == ")":
                cur_right += 1
            elif i == "(":
                total_left += 1
                if cur_right == 0:
                    left_to_remove += 1
                else:
                    cur_right -= 1
        return total_left - left_to_remove
```