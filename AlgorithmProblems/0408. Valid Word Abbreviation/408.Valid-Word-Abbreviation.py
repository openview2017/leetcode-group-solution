"""
Use two pointers and move simultaniously. Check whether the corresponding characters are the same.
Time complexity: O(n) n=> length of the word.
Space complexity: O(1) because we are using two pointers.
"""

class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        i = j = 0
        while i < len(word) and j < len(abbr):
            if abbr[j].isalpha():
                if word[i] != abbr[j]:
                    return False
                i += 1
                j += 1
            else:
                if abbr[j] == "0" and (j == 0 or abbr[j-1].isalpha()):
                    return False
                num = 0
                while j < len(abbr) and abbr[j].isdigit():
                    num = num*10 + int(abbr[j])
                    j += 1
                i += num
        if i != len(word) or j != len(abbr):
            return False
        return True