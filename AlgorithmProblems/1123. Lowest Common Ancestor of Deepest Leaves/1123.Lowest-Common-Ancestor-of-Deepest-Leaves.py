# Definition for a binary tree node.
"""
Time complexity: O(N) N => number of nodes
Space complexity: O(H) H => height of tree
"""

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def lcaDeepestLeaves(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        _, lca = self.helper(root)
        return lca
        
    def helper(self, root):
        if not root:
            return 0, None
        l_height, l_lca = self.helper(root.left)     
        r_height, r_lca = self.helper(root.right)
        if l_height > r_height:
            return l_height+1, l_lca
        elif l_height < r_height:
            return r_height+1, r_lca
        else:
            return l_height+1, root