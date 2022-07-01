
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        pre, cur = None, head
        
        while cur:
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        return pre
