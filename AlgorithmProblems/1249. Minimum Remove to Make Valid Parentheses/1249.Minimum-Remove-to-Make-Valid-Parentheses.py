class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        to_remove = set()

        left = 0
        for i in range(len(s)):
            if s[i] == "(":
                left += 1
            elif s[i] == ")":
                if left > 0:
                    left -= 1
                else:
                    to_remove.add(i)
        
        right = 0
        for i in range(len(s)-1, -1, -1):
            if s[i] == ")":
                right += 1
            elif s[i] == "(":
                if right > 0:
                    right -= 1
                else:
                    to_remove.add(i)
                    
        result = ""
        for i in range(len(s)):
            if i in to_remove:
                continue
            result += s[i]
        return result
                