"""
TC: O(N)
SC: O(1)
"""

class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        left = 0  # The number of right parentheses needed
        right = 0# The number of left parentheses needed
        for i in s:
            if i == "(":
                left += 1
            else:
                if left > 0:
                    left -= 1
                else:
                    right += 1
        return left + right