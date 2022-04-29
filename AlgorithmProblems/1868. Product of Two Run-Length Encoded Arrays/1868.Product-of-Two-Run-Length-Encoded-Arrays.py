from typing import List
"""
Two pointers. Pick the mininum length and calculate the result each time. If one list is used up, then move pointer to the next element.
Time complexity: O(M + N) => M is the length of array1 and N is the length of array2.
"""
class Solution:
    def findRLEArray(self, encoded1: List[List[int]], encoded2: List[List[int]]) -> List[List[int]]:
        l = r = 0
        result = []
        while l < len(encoded1) and r < len(encoded2):
            min_len = min(encoded1[l][1], encoded2[r][1])
            if result and encoded1[l][0] * encoded2[r][0] == result[-1][0]:
                result[-1][1] += min_len
            else:
                result.append([encoded1[l][0] * encoded2[r][0], min_len])
            encoded1[l][1] -= min_len
            encoded2[r][1] -= min_len
            if encoded1[l][1] == 0:
                l += 1
            if encoded2[r][1] == 0:
                r += 1
        return result
            
            