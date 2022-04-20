
from Queue import PriorityQueue
class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next
    
class Solution0023:
    def mergeKLists(self, lists):
        dum = cur = ListNode(0)
        q = PriorityQueue()
        #init
        for l in lists:
            if l:
                q.put((l.val, l))
        while not q.empty():
            val, node = q.get()
            cur.next = ListNode(val)
            node = node.next
            cur = cur.next
            if node:
                q.put((node.val, node))
        return dum.next
