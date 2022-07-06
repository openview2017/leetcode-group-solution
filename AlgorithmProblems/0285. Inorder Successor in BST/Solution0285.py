# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def inorderSuccessor(self, root: TreeNode, p: TreeNode) -> Optional[TreeNode]:
        cand = None
        cur = root
        while cur:
            if cur.val > p.val:
                cand = cur
                cur  = cur.left
            else:
                cur = cur.right
        return cand