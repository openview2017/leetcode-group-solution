
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution0021:
    def mergeTwoLists(self, list1, list2):
        """
        :type list1: Optional[ListNode]
        :type list2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        dum = ListNode(0)
        cur = dum
        while list1 and list2:
            if list1.val <= list2.val:
                cur.next = list1
                list1 = list1.next
            else:
                cur.next = list2
                list2 = list2.next
            cur = cur.next
            
        if list1:
            cur.next = list1
        else:
            cur.next = list2
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

sol = Solution0021()
a1 = [1,2,4]
a2 = [1,3,4]
h1 = sol.lst2link(a1)
h2 = sol.lst2link(a2)
print(sol.print(h1))
print(sol.print(h2))
print("Merged:")
res = sol.mergeTwoLists(h1, h2)
print(sol.print(res)) 
