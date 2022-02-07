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
        