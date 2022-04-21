


class Solution243(object):
    def shortestDistance(self, wordsDict, word1, word2):
        """
        :type wordsDict: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        i1, i2 = -1, -1
        res = len(wordsDict) + 1
        for x in range(len(wordsDict)):
            if wordsDict[x] == word1:
                i1 = x
            elif wordsDict[x] == word2:
                i2 = x
            if i1 != -1 and i2 != -1:
                res = min(res, abs(i2 - i1))
                
        return res