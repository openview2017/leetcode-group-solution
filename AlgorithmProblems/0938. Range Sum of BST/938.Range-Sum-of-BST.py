# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Recursive method
class Solution1:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if not root:
            return 0
        if root.val < low:
            return self.rangeSumBST(root.right, low, high)
        if root.val > high:
            return self.rangeSumBST(root.left, low, high)
        else:
            return root.val + self.rangeSumBST(root.left, low, high) + self.rangeSumBST(root.right, low, high)

# Iterative method
class Solution2:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        dummy = TreeNode(right=root)
        stack = [dummy]
        sum_val = 0
        while stack:
            cur = stack.pop()
            if low <= cur.val <= high:
                sum_val += cur.val
            cur = cur.right
            while cur:
                stack.append(cur)
                cur = cur.left
        return sum_val
        