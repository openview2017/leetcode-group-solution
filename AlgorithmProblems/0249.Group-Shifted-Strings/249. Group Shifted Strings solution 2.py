import collections
class Solution:
    """
    @param strings: a string array
    @return: return a list of string array
    """
    def __init__(self):
        self.ALF_LEN = 26
    def groupStrings(self, strings):
        # write your code here
        hashT = collections.defaultdict(list)
        for s in strings:
            hashT[self.build_key(s)].append(s)
        return hashT.values()

    def build_key(self, s):
        return tuple([(ord(c) - ord(s[0])) % self.ALF_LEN for c in s])
    
