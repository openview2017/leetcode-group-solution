"""
Calculate the result as binaries. Each time add the current bit to the result.
Time complexity: O(logn)
Space complexity: O(1)
"""
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if x == 0:
            return 0
        if n < 0:
            x = 1/ x
            n = -n
        cur = 1
        while n:
            cur *= x**(n%2)
            n //= 2
            x = x**2
        return cur