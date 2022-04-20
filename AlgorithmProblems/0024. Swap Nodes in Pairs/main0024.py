class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution0024:
    def swapPairs(self, head: ListNode) -> ListNode:        
        """
        :type head: ListNode
        :rtype: ListNode
        """
        # Dummy node acts as the prevNode for the head node
        # of the list and hence stores pointer to the head node.
        if not head or not head.next:
            return head
        
        first_node = head
        second_node = head.next

        first_node.next = self.swapPairs(second_node.next)
        second_node.next = first_node

        return second_node

    def swapPairsIter(self, head: ListNode) -> ListNode:
        dum = ListNode(0)
        dum.next = head
        prev = dum

        while head and head.next:
            # Nodes to be swapped
            first_node = head
            second_node = head.next

            # Swapping
            prev.next = second_node
            first_node.next = second_node.next
            second_node.next = first_node

            # Reinitializing the head and prev_node for next swap
            prev = first_node
            head = first_node.next
        
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

sol = Solution0024()
a1 = [1,2,3,4]   
h1 = sol.lst2link(a1)
print(sol.print(h1))
print("Recursion:")
res = sol.swapPairs(h1)
print(sol.print(res)) 
print("Iteration:")
h1 = sol.lst2link(a1)
res = sol.swapPairsIter(h1)
print(sol.print(res)) 

