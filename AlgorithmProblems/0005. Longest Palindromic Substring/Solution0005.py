# tc:o(n2), sc:o(1)

class Solution0005:

    def __init__(self):
        self.lo = 0
        self.maxlen = 1
        
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        for i in range(len(s)):
            self.__extendPalindrome(s, i, i)
            self.__extendPalindrome(s, i, i+1)
        return s[self.lo : self.lo + self.maxlen]
    
    def __extendPalindrome(self, s, left, right):
        while(left >= 0 and right < len(s) and s[left] == s[right]):
            left -= 1
            right += 1
        if self.maxlen < right - left - 1:
            self.lo = left + 1
            self.maxlen = right - left - 1