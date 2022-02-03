# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

"""
Using BFS to go through all nodes and clone the nodes at the same time.
Store the cloned nodes into a hashmap which can also be used as a visited set.

Time complexity: O(V+E)
Space complexity: O(V)
"""
from collections import deque
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return node
        nodemap = dict()
        queue = deque([node])
        nodemap[node] = Node(node.val, [])
        while queue:
            cur = queue.pop()
            cloned_cur = nodemap[cur]
            for neighbor in cur.neighbors:
                if neighbor not in nodemap:
                    cn = Node(neighbor.val, [])
                    nodemap[neighbor] = cn
                    queue.append(neighbor)
                cloned_cur.neighbors.append(nodemap[neighbor])
        return nodemap[node]