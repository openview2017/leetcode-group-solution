class Solution:
    def isNumber(self, s: str) -> bool:
        if self.isIntegerWithSign(s) or self.isDecimalWithSign(s):
            return True
        s_list = s.lower().split("e")
        if len(s_list) != 2:
            return False
        if (self.isIntegerWithSign(s_list[0]) or self.isDecimalWithSign(s_list[0])) and self.isIntegerWithSign(s_list[1]):
            return True
        return False
    
    # To check whether a string is an integer which can have sign.
    def isIntegerWithSign(self, s):
        if not s:
            return False
        if s[0] in {"+","-"}:
            return self.isInteger(s[1:])
        return self.isInteger(s)
    
    # To check whether a string is a strict integer without any sign.
    def isInteger(self, s):
        if not s:
            return False
        for i in range(len(s)):
            if not s[i].isdigit():
                return False
        return True

    # To check whether a string is a decimal which can have sign.
    def isDecimal(self, s):
        s_list = s.split(".")
        if len(s_list) != 2:
            return False
        flag = False
        if self.isIntegerWithSign(s_list[0]):
            if not s_list[1] or self.isInteger(s_list[1]):
                return True
        elif self.isInteger(s_list[1]):
            if not s_list[0] or self.isIntegerWithSign(s_list[0]):
                return True
        else:
            return False

    # To check whether a string is a strict decimal without any sign.
    def isDecimalWithSign(self, s):
        if not s:
            return False
        if s[0] in {"+","-"}:
            return self.isDecimal(s[1:])
        return self.isDecimal(s)
        
    
    """
    isInteger: True: +3 -234 False: 3e, +3.0, -2.
    """