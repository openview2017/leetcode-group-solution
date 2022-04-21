# Definition for singly-linked list.

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
# 17
class Solution002:
    def addTwoNumbers(self, l1, l2):
        carry = 0
        cur = dum = ListNode(0)
        while l1 or l2 or carry:
            if l1:
                carry += l1.val
                l1 = l1.next
            if l2:
                carry += l2.val
                l2 = l2.next
            cur.next = ListNode(carry%10)  
            carry //= 10  
            cur = cur.next
            
        if carry != 0:
            cur.next = ListNode(carry)
            cur = cur.next
        
        return dum.next

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
    

sol = Solution002()
a1 = [2,4,3]
a2 = [5,6,4]
h1 = sol.lst2link(a1)
h2 = sol.lst2link(a2)
res = sol.addTwoNumbers(h1, h1)
print(sol.print(res))

