class Solution0171:
    def titleToNumber(self, columnTitle: str) -> int:
        res = 0
        for i in range(len(columnTitle)):
            res *= 26
            res += (ord(columnTitle[i]) - ord('A') + 1)
        return res