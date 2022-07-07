from typing import List


class Solution1423:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        n = len(cardPoints)
        frontscore, rearscore = sum(cardPoints[0:k]), 0
        maxscore = frontscore
        for i in range(1,k+1):
            frontscore -= cardPoints[k-i]
            rearscore += cardPoints[n-i]
            maxscore = max(maxscore, frontscore + rearscore)
        return maxscore