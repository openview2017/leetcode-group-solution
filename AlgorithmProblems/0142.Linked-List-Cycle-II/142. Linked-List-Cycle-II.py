class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return None
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                break
        if not fast.next or not fast.next.next:
            return None
        slow = head
        while fast.next:
            if slow == fast:
                return slow
            slow = slow.next
            fast = fast.next
        return None