# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution0113:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res, cur = [], []
        self.helper(root, targetSum, cur, res)
        return res

    def helper(self, root: Optional[TreeNode], targetSum: int, cur: List[int], res: List[List[int]]):
        if not root:
            return
        
        cur.append(root.val)
        if (not root.left) and (not root.right) and root.val == targetSum:
            res.append(list(cur))
            
        newSum = targetSum - root.val
        self.helper(root.left, newSum, cur, res)        
        self.helper(root.right, newSum, cur, res)

        cur.pop()