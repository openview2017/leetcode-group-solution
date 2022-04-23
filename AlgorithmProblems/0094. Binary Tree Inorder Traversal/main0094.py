# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution0094(object):
    def inorderTraversalIter(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res, stack = [],[]
        cur = root
        while cur != None or len(stack) != 0:
            if cur != None:
                stack.append(cur)
                cur = cur.left
            else:
                cur = stack.pop()
                res.append(cur.val)
                cur = cur.right      
        return res
    
    def inorderTraversalRec(self, root):
        res = []
        self.helper(root, res)
        return res
    
    def helper(self, root, res):
        if root:
            self.helper(root.left, res)
            res.append(root.val)
            self.helper(root.right, res)