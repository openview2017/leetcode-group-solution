from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        mid = self.findMiddle(head)
        left = head
        right = mid.next
        mid.next = None
        right = self.reverseList(right)
        return self.mergeTwoLists(left, right)
        
    def findMiddle(self, head):
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        return slow
    
    def reverseList(self, head):
        cur = None
        while head:
            new_head = head.next
            head.next = cur
            cur = head
            head = new_head
        return cur
    
    def mergeTwoLists(self, left, right):
        head = ListNode()
        cur = head
        while left and right:
            new_left, new_right = left.next, right.next
            cur.next = left
            cur.next.next = right
            cur = right
            left, right = new_left, new_right
        if left:
            cur.next = left
        if right:
            cur.next = right
        return head.next