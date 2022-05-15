class Solution0475:
    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        houses.sort()
        heaters.sort()
        
        m, n = len(houses), len(heaters)
        i, j = 0, 0
        heatRad = 0
        
        while i < m and j < n:
            curDist = abs(heaters[j] - houses[i])
            nextDist = float('inf')
            if j < n - 1:
                nextDist = abs(heaters[j+1] - houses[i])
            if curDist < nextDist:
                heatRad = max(heatRad, curDist)
                i += 1
            else:
                j += 1
        
        return heatRad


        