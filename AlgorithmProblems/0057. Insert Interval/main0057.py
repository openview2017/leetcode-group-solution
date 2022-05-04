from typing import List


class Solution0057:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        n = len(intervals)
        idx, ridx = 0, 0
        output = []
        
        while idx < n and intervals[idx][1] < newInterval[0]:
            output.append(intervals[idx])
            idx += 1
        
        while idx < n and intervals[idx][0] <= newInterval[1]:
            newInterval[0] = min(newInterval[0], intervals[idx][0])            
            newInterval[1] = max(newInterval[1], intervals[idx][1])
            idx += 1
        output.append(newInterval)
        
        while idx < n and intervals[idx][0] > newInterval[1]:
            output.append(intervals[idx])
            idx += 1     
        
        return output

sol = Solution0057()
intervals = [[1,3],[6,9]]
newInterval = [2,5]
res = sol.insert(intervals,newInterval)
print(res)

intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]
newInterval = [4,8]
res = sol.insert(intervals,newInterval)
print(res)
