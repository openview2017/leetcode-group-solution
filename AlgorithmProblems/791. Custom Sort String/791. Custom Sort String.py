"""
TC: O(M + N)    M is length of order, N is length of s
SC: O(N)
"""
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        s_dict = dict()
        for i in s:
            if i in s_dict:
                s_dict[i] += 1
            else:
                s_dict[i] = 1
        
        result = []
        for i in order:
            while i in s_dict and s_dict[i] > 0:
                result.append(i)
                s_dict[i] -= 1
        for key, val in s_dict.items():
            while val != 0:
                result.append(key)
                val -= 1
        return "".join(result)
        