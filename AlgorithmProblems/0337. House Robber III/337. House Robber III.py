"""
Divide and conquer.
dfs functon returns the max value we can get by robbing the current node and not robbing the current node.

TC: O(N) N is the number of nodes
SC: O(H) => O(logN) H is the height of the tree.

"""
from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        rob, no_rob = self.dfs(root)
        return max(rob, no_rob)
        
    def dfs(self, root):
        if not root:
            return 0, 0
        l_rob, l_no_rob = self.dfs(root.left)
        r_rob, r_no_rob = self.dfs(root.right)
        rob = l_no_rob + r_no_rob + root.val
        no_rob = max(l_rob, l_no_rob) + max(r_rob, r_no_rob)
        return rob, no_rob
        