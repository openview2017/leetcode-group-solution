# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution0101:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.dfs(root, root)
        
    def dfs(self, root1:TreeNode, root2:TreeNode) -> bool:
        if not root1 and not root2:
            return True
        elif not root1 or not root2:
            return False
        
        return root1.val == root2.val and self.dfs(root1.left, root2.right) and self.dfs(root1.right, root2.left)
        