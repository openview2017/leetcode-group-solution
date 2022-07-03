from typing import List


class Solution0131:
    def partition(self, s: str) -> List[List[str]]:
      
      m = len(s)
      dp = [[0] * m for _ in range(m)]
      
      for i in range(m):
        dp[i][i] = 1
      
      for i in range(m)[::-1]:
        for j in range(i + 1, m):
          if s[i] == s[j] and (j - i < 3 or dp[i + 1][j - 1]):
            dp[i][j] = 1
      
      out = [[] * m for _ in range(m)]
      
      for i in range(m):
        if dp[i][-1]:
          out[i].append([s[i:]])
      
      for j in range(m - 1)[::-1]:
        for i in range(j + 1):
          if dp[i][j]:
            for v in out[j + 1]:
              out[i].append([s[i:j + 1]] + v)
              
      return out[0]