
class Solution0156(object):
    def upsideDownBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if (not root) or (not root.left):
            return root
        newRoot = self.upsideDownBinaryTree(root.left)
        root.left.right = root
        root.left.left = root.right
        root.left = None
        root.right = None
        return newRoot

class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

sol = Solution0156()
root =  TreeNode(1)
root.left =  TreeNode(2)
root.right =  TreeNode(3)
cur = root
cur = cur.left
cur.left =  TreeNode(4)
cur.right =  TreeNode(5)        
res = sol.upsideDownBinaryTree(root)
print(root.val)
print(res.val)
