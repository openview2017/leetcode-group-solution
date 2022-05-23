from heapq import heappop, heappush


class Solution0378(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        row, col = len(matrix), len(matrix[0])
        minheap = []
        for r in range(min(k, row)):
            heappush(minheap, (matrix[r][0], r, 0))

        for i in range(k):
            res, curr, curc = heappop(minheap)
            if curc + 1 < col: heappush(minheap, (matrix[curr][curc+1], curr, curc + 1))
        return res

sol = Solution0378()
matrix = [[1,5,9],[10,11,13],[12,13,15]]
k = 8
res = sol.kthSmallest(matrix, k)
print(res)
        