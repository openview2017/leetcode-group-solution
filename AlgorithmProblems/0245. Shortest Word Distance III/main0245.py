from typing import List


class Solution0245:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        wordLen = len(wordsDict)
        prev = -1
        isEqual = (word1 == word2)
        res = wordLen
        for i in range(wordLen):
            if wordsDict[i] == word1 or wordsDict[i] == word2:
                if prev != -1 and (isEqual or wordsDict[prev] != wordsDict[i]):
                    res = min(res, i - prev)
                prev = i
        
        return res

wordsDict = ["practice", "makes", "perfect", "coding", "makes"]
word1 = "makes"
word2 = "coding"
sol = Solution0245()
res = sol.shortestWordDistance(wordsDict, word1, word2)
print(res)

wordsDict = ["practice", "makes", "perfect", "coding", "makes"]
word1 = "makes"
word2 = "makes"
sol = Solution0245()
res = sol.shortestWordDistance(wordsDict, word1, word2)
print(res)