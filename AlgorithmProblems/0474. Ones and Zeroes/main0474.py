from typing import List


class Solution0474:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        res = [[0 for _ in range(n+1)] for _ in range(m+1)]
        for str in strs:
            zeros = str.count("0")
            ones = len(str) - zeros
            for i in range(m, zeros-1, -1):
                for j in range(n, ones-1, -1):
                    res[i][j] = max(res[i][j], res[i-zeros][j-ones] + 1)
        return res[m][n]
    
# >>> CM = [[0 for _ in range(10)]] * 10
# Is copying a reference to the same object, ten times. It is equivalent to this:

# >>> x = [0 for _ in range(10)]
# >>> CM = [x, x, x, x, x, x, x, x, x, x]

sol = Solution0474()
strs = ["10","0001","111001","1","0"]
m, n=5, 3
res = sol.findMaxForm(strs,m,n)
print(res)