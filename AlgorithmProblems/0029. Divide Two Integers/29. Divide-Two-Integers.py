"""
Time complexity: O(logN)
Space complexity: O(1)
"""

class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        sign = 1
        if dividend < 0:
            sign = 1-sign
            dividend = -dividend
        if divisor < 0:
            sign = 1-sign
            divisor = -divisor
            
        if divisor == 0:
            raise ValueError("Divisor equals zero.")
        memo = divisor
        result = 0
        cur = 1
        while (memo<<1) <= dividend:
            memo <<= 1
            cur <<= 1
            
        while memo >= divisor:
            if dividend - memo >= 0:
                dividend -= memo
                result += cur
            else:
                memo >>= 1
                cur >>= 1
        result = result if sign else -result
        if result > (1<<31) - 1:
            result = (1<<31) - 1
        if result < -1<<31:
            result = -1<<31
        return result