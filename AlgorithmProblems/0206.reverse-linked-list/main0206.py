
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution0206:
    def reverseListRec(self, head):
        if (not head) or (not head.next):
            return head
        newHead = self.reverseListRec(head.next)
        head.next.next = head
        head.next = None
        return newHead

    def reverseListIter(self, head):
        prev, cur = None, head
        while cur:
            next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        return prev

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

sol = Solution0206()
a1 = [1,2,3,4]   
h1 = sol.lst2link(a1)
print(sol.print(h1))
print("Recursion:")
res = sol.reverseListRec(h1)
print(sol.print(res)) 

print("Iteration:")
h1 = sol.lst2link(a1)
res = sol.reverseListIter(h1)
print(sol.print(res)) 

