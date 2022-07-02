class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        ref = 1
        while ref * 3 < 2**31:
            ref *= 3
        return n > 0 and ref % n == 0