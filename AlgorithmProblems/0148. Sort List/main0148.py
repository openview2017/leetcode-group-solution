class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution0148:
    def mergeTwo(self, l1, l2):
        dummy = ListNode(0)
        tail = dummy
        while l1 and l2:
            if l1.val > l2.val: l1, l2 = l2, l1
            tail.next = l1
            l1 = l1.next
            tail = tail.next
        tail.next = l1 if l1 else l2
        return dummy.next  

    def sortList(self, head):        
        if (not head) or (not head.next): 
            return head
        slow = head
        fast = head.next
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        mid = slow.next
        slow.next = None
        return self.mergeTwo(self.sortList(head), self.sortList(mid))

    def lst2link(self, lst):
        cur = dummy = ListNode(0)
        for e in lst:
            cur.next = ListNode(e)
            cur = cur.next
        return dummy.next

    def print(self, lst):
        # defining a blank res variable
        res = ""
        # initializing ptr to head
        ptr = lst
       # traversing and adding it to res
        while ptr:
            res += str(ptr.val) + ", "
            ptr = ptr.next
       # removing trailing commas
        res = res.strip(", ")
        # chen checking if
        # anything is present in res or not
        if len(res):
            return "[" + res + "]"
        else:
            return "[]"

sol = Solution0148()
a1 = [1,3,4,2]
h1 = sol.lst2link(a1)
print(sol.print(h1))
res = sol.sortList(h1)
print(sol.print(res)) 
