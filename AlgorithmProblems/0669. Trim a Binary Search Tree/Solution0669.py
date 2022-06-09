class Solution0669:
    def trimBST(self, root: Optional[TreeNode], low: int, high: int) -> Optional[TreeNode]:
        if not root: 
            return root
        if root.val < low: 
            return self.trimBST(root.right, low, high)
        if root.val > high: 
            return self.trimBST(root.left, low, high)
        root.left = self.trimBST(root.left, low, high)
        root.right = self.trimBST(root.right, low, high)
        return root