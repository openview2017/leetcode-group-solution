from typing import List


class Solution0207:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        G = [[] for i in range(numCourses)]
        degree = [0]*numCourses
        
        for j, i in prerequisites:
            G[i].append(j)
            degree[j] += 1
            
        bfs = [i for i in range(numCourses) if degree[i] == 0]
        for i in bfs:
            for j in G[i]:
                degree[j] -= 1
                if degree[j] == 0:
                    bfs.append(j)
        return len(bfs) == numCourses
    
