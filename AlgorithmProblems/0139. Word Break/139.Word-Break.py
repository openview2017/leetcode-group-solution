"""
Dynamic programing to solve this problem.
Time complexity: O(N**2)
Space complexity: O(N)
N is the length of the input word.
"""
from typing import List

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False for i in range(len(s)+1)]
        dp[0] = True
        wordSet = set(wordDict)
        for i in range(1, len(dp)):
            for j in range(i):
                if dp[j] and s[j:i] in wordSet:
                    dp[i] = True
        return dp[-1]
        