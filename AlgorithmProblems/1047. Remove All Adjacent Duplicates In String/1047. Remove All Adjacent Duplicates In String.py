"""
TC: O(N)
SC: O(N)
"""
class Solution:
    def removeDuplicates(self, s: str) -> str:
        stack = []
        for i in s:
            if not stack or stack[-1] != i:
                stack.append(i)
            else:
                stack.pop()
        return "".join(stack)