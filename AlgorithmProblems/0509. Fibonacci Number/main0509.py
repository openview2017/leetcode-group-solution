import copy
from typing import List
class Solution0509:
    def fib(self, N: int) -> int:
        if (N <= 1):
            return N

        current = 0
        prev1 = 1
        prev2 = 0

        # Since range is exclusive and we want to include N, we need to put N+1.
        for i in range(2, N + 1):
            current = prev1 + prev2
            prev2 = prev1
            prev1 = current
        return current

############################################

    def fib_matrix(self, n: int) -> int:
        if n <= 1:
            return n
        
        A = [[1,1],[1,0]]
        res = self.matrix_power(A, n-2)
        return res[0][0]

    def matrix_power(self, A: List[List[int]], n: int) -> None:
        res = copy.deepcopy(A)
        c = copy.deepcopy(A)
        while n > 0:
            if n&1 != 0:
                res = self.multiply(res, c)
            c = self.multiply(c, c)
            n >>= 1
        return res
    
    def multiply(self, M: List[List[int]], N: List[List[int]]) -> List[List[int]]:
        ra, ca, rb, cb = len(M), len(M[0]), len(N), len(N[0])
        ans = [[0 for _ in range(cb)] for _ in range(ra)]
        for i in range(ra):
            for j in range(cb):
                for k in range(ca):
                    ans[i][j] += M[i][k] * N[k][j]
        return ans    
        
sol = Solution0509()
N = 10
res = sol.fib_matrix(N)
print(res) 
res = sol.fib(N)
print(res) 