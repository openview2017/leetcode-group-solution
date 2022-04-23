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
        