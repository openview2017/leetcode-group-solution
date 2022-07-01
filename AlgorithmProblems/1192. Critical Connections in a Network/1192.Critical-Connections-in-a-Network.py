from types import List
class Solution:
    def __init__(self):
        self.step = 0
        
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        # Build a graph with the current connections.
        graph = dict()
        for i, j in connections:
            if i not in graph:
                graph[i] = {j}
            else:
                graph[i].add(j)
            if j not in graph:
                graph[j] = {i}
            else:
                graph[j].add(i)
        
        # Disc to track the order of nodes visited.
        # The first node visited will be 0, then 1, etc.
        disc = [-1 for i in range(n)]
        # Low value represents if the cur node can reach a node with lower disc number.
        # If a node has a different low value from it's own disc number, that means it has another route to reach the earlier visited node.
        low = [-1 for i in range(n)]
        # Parent records the last node from which we are visiting the current node.
        parent = [-1 for i in range(n)]
        result = []
        for i in range(n):
            if disc[i] != -1: # Current node has been visited.
                continue
            self.dfs(i, low, disc, parent, graph, result)
        return result
    
    def dfs(self, cur, low, disc, parent, graph, result):
        if disc[cur] != -1: # Current node has been visited.
            return
        disc[cur] = low[cur] = self.step # Initialize the disc and low each time we meet with a new node.
        self.step += 1  # step records how many nodes we have visited (The order number of current node.)
        for neighbor in graph[cur]:
            if disc[neighbor] == -1: # Neighbor has not been visited.
                parent[neighbor] = cur # Cur is the parent of its unvisited neighbor.
                self.dfs(neighbor, low, disc, parent, graph, result)
                # If neighbor has a smaller low number, that means there is another root for the neighboor to reach a node prior to current node.
                # It means there is a loop/SCC (Strongly connected component)
                # If there is not a smaller low number, that means cur and neighbor is not within the same loop/SCC. Then we find a critical connection.
                if (low[neighbor] > disc[cur]):
                    result.append([cur, neighbor])
                # We update cur's low value with neighbor's low value
                low[cur] = min(low[cur], low[neighbor])
            # If neighbor is visited and it isn't current node's parent. That means we will not revisit the cur node from its neighbor.
            elif parent[cur] != neighbor:
                # We only compare low values when it's backtracking. 
                # In this case, neighbor is the closing of the loop. We update cur's low value with its neighbor's disc value.
                low[cur] = min(low[cur], disc[neighbor])
        return
            
        