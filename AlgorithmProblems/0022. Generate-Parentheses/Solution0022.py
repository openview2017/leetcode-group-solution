from typing import List


class Solution0022:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        def dfs(S = [], left = 0, right = 0):
            if len(S) == 2 * n:
                ans.append("".join(S))
            if left < n:
                S.append("(")
                dfs(S, left + 1, right)
                S.pop()
            if right < left:
                S.append(")")
                dfs(S, left, right + 1)
                S.pop()
        dfs()
        return ans

sol = Solution0022()
ans = sol.generateParenthesis(3)
print(ans)