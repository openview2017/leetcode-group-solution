class Solution:
    def trailingZeroes(self, n: int) -> int:
        zeros = 0
        for i in range(5,n+1,5):
            cur = i
            while (cur % 5 == 0):
                zeros += 1
                cur /= 5
        return zeros