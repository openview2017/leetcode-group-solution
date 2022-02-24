from typing import List, Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

"""
DFS fucntion to return the level of each node. The current level of each node is max(leftnode, rightnode) + 1
Append result when we get each node's level.
TC: O(N)
SC: O(log(N))
"""
class Solution:
    def findLeaves(self, root: Optional[TreeNode]) -> List[List[int]]:
        node_level = []
        self.getLevels(root, node_level)
        return node_level
        
    def getLevels(self, root, node_level):
        # Level of null value is 0
        if not root:
            return 0
        left_level = self.getLevels(root.left, node_level)
        right_level = self.getLevels(root.right, node_level)
        cur_level = max(left_level, right_level) + 1
        # Leaf node level starts from 1, and we fill it in to the 0th index of result array.
        if cur_level-1 < len(node_level):
            node_level[cur_level-1].append(root.val)
        else:
            node_level.append([root.val])
        return cur_level
        