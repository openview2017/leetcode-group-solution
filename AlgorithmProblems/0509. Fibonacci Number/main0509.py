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

sol = Solution0509()
N = 10
res = sol.fib(N)
print(res) 