from collections import defaultdict
from typing import List

class Solution0149:
    def maxPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        if n < 3: return n
        ans = 0
        
        def gcd(a, b) -> int:
            while b != 0:
                a, b = b, a % b
            return a
        
        for i in range(n-1):
            hash_map = defaultdict(lambda: 0) # set default value to 0
            for j in range(i+1, n):
                dx = points[i][0] - points[j][0]       
                dy = points[i][1] - points[j][1]
                gcdcur = gcd(dx, dy)
                key = tuple((dx//gcdcur, dy//gcdcur))
                hash_map[key] += 1
            max_alignment = max(hash_map.values()) # find max points algin with point i 
            ans = max(ans, max_alignment+1) # + 1 to add point i
        
        return ans

sol = Solution0149()
points = [[1,1],[2,2],[3,3]]
ans = sol.maxPoints(points)
print(ans)

points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
ans = sol.maxPoints(points)
print(ans)
# https://leetcode.cn/problems/max-points-on-a-line/solution/gong-shui-san-xie-liang-chong-mei-ju-zhi-u44s/    