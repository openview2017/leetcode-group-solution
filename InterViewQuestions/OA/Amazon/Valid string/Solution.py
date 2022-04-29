"""
Use stack to remove char pairs.
Time complexity: O(N)
Space complexity: O(N)
N is the length of string.
"""
from collections import deque
class ValidString:
    def isValid(self, s: str) -> bool:
        stack = deque([])
        for i in s:
            if not i.isalpha():
                return False
            if not stack or stack[-1] != i:
                stack.append(i)
            else:
                stack.pop()
        if stack:
            return False
        return True

# vv, xbbx, bbccdd, xyffyxdd
if __name__ == "__main__":
    # Test case1
    input_string = "xyffyxdd"
    vs = ValidString()
    print(vs.isValid(input_string))
    print("Expected result: {}".format(True))
    # Test case2
    input_string = "aabbcbbaa"
    vs = ValidString()
    print(vs.isValid(input_string))
    print("Expected result: {}".format(False))
    # Test case3
    input_string = "abaccaba"
    vs = ValidString()
    print(vs.isValid(input_string))
    print("Expected result: {}".format(True))
