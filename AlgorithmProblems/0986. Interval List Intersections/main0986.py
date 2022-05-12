from typing import List


class Solution0986:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        res = []
        i, j = 0, 0
        m, n = len(firstList), len(secondList)
        while i < m and j < n:
            left, right = max(firstList[i][0], secondList[j][0]), min(firstList[i][1], secondList[j][1])
            if left <= right:
                res.append([left, right])
            if firstList[i][1] < secondList[j][1]:
                i += 1
            else:
                j += 1
        return res

sol = Solution0986()
firstList = [[0,2],[5,10],[13,23],[24,25]]
secondList = [[1,5],[8,12],[15,24],[25,26]]
res = sol.intervalIntersection(firstList, secondList)
print(res)