from typing import Optional

# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

"""
Recursive solution. Using divide and conquer.
Time complexity: O(N) N denotes the number of nodes
Space complexity: O(logN)
"""
class Solution1: 
    def treeToDoublyList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root
        head, tail = self.dfs(root)
        head.left = tail        # Connect head to tail
        tail.right = head       # Connect tail to head
        return head
    
    """
    Summary: Using divide and conquer method.
    Keyword arguments:
        root -- input root node
    Return arguments:
        head -- head of flattened doublylist
        tail -- tail of flattened doublylist
    """
    def dfs(self, root):
        if not root:
            return None, None
        l_left, l_right = self.dfs(root.left)
        r_left, r_right = self.dfs(root.right)
        head = tail = root
        if l_right:
            l_right.right = root
            root.left = l_right
            head = l_left
        if r_left:
            r_left.left = root
            root.right = r_left
            tail = r_right
        return head, tail

"""
Iterative solution. Using stack to track.
Time complexity: O(N) N denotes the number of nodes
Space complexity: O(logN)
"""               
class Solution2:
    def treeToDoublyList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root
        head = tail = Node(0, right=root)
        stack = [head]
        while stack:
            cur = stack.pop()
            if cur.right:
                cur = cur.right
                while cur:
                    stack.append(cur)
                    cur = cur.left
            if stack:
                node = stack[-1]
                node.left = tail
                tail.right = node
                tail = node
        # Current head is actually dummy node. Need to move to the real head.
        head = head.right
        # Connect head and tail to form a circle
        tail.right = head
        head.left = tail
        return head
                