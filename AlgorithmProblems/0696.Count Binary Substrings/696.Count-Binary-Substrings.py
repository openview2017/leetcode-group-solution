"""
00011011 => [3,2,1,2] => min(3,2) + min(2,1) + min(1,2)
Time complexity: O(N)
Space complexity: O(1)
"""
class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        last = 0
        cur = 1
        result = 0
        for i in range(1, len(s)):
            if s[i] == s[i-1]:
                cur += 1
            else:
                result += min(last, cur)
                last = cur
                cur = 1
        result += min(last, cur)
        return result
  