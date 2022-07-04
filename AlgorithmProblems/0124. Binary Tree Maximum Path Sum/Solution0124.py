# Definition for a binary tree node.

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution0124:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        def max_gain(root):
            nonlocal max_sum
            if not root:
                return 0
            left = max(max_gain(root.left), 0)            
            right = max(max_gain(root.right), 0)
            max_sum = max(max_sum, left + right + root.val)
            
            return max(left, right) + root.val
        
        max_sum = float("-inf")
        max_gain(root)
        return max_sum