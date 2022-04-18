"""
Hash each string into a hash key and make it as the key of the hashmap. The hashkey is made up of the relative order of each character in string to the first character.
For example:
abcd => [0,1,2,3] => "0#1#2#3" as the key. If the relative order is negative, then we mod it by 26 to get the positive number.
yzab => [0,1,-24,-23] => [0,1,2,3] => "0#1#2#3"
TC: O(N * K)  N is the length of strings, K is the average length of string.
SC: O(N * K)
"""

from typing import List
class Solution:
    def groupStrings(self, strings: List[str]) -> List[List[str]]:
        shift_seq = dict()
        for s in strings:
            str_pattern = []
            for char in s:
                str_pattern.append(str((ord(char)-ord(s[0])) % 26))
            str_key = "#".join(str_pattern)
            if str_key in shift_seq:
                shift_seq[str_key].append(s)
            else:
                shift_seq[str_key] = [s]
        return [x for x in shift_seq.values()]