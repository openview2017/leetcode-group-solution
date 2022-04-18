from typing import List
"""
Without Memo
"""
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        result = []
        wordSet = set(wordDict)
        self.dfs(s, 0, wordSet, [], result)
        return result
    
    def dfs(self, s, idx, wordSet, path, result):
        if idx == len(s):
            result.append(" ".join(path))
            return
        for i in range(idx, len(s)+1):
            if s[idx:i] not in wordSet:
                continue
            path.append(s[idx:i])
            self.dfs(s, i, wordSet, path, result)
            path.pop()
        return

"""
With Memo
"""
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        wordSet = set(wordDict)
        memo = dict()
        return self.dfs(s, 0, wordSet, memo)
    
    def dfs(self, s, idx, wordSet, memo):
        result = []
        if idx in memo:
            return memo[idx]
        if s[idx:] in wordSet:
            result = [s[idx:]]
            memo[idx] = [s[idx:]]
        for i in range(idx, len(s)):
            if s[idx:i] in wordSet:
                sub_result = self.dfs(s, i, wordSet, memo) 
                for res in sub_result:
                    result.append(s[idx:i] + " " + res)
        memo[idx] = result
        return result
                