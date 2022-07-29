from typing import List


class Solution1557:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        res = []
        deg = [0] * n
        for edge in edges:
            deg[edge[1]] += 1
        for i in range(n):
            if deg[i] == 0:
                res.append(i)
        return res