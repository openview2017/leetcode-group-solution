class Solution0070:
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return n
        first, second = 1, 1
        for _ in range(2, n+1):
            second, first = first + second, second
        return second