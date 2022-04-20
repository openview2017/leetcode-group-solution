class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution0025:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head

        pre, end = dummy, dummy

        while end.next:
            # 取出待翻转的部分
            i = 0
            while i < k and end:
                end = end.next
                i += 1
            if not end: break

            # 断开链表
            startNode = pre.next
            nextNode = end.next
            end.next = None

            # 处理翻转 
            pre.next = self.reverse(startNode)
            # startNode 转到翻转这部分节点的最后了

            # 连接断开的链表
            startNode.next = nextNode

            # 挪动以进行下一组处理
            pre = startNode
            end = pre
        return dummy.next

    def reverse(self, head):
        pre = None
        curr = head
        while curr:
            nextNode = curr.next
            curr.next = pre
            pre = curr
            curr = nextNode
        return pre

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

sol = Solution0025()
a1 = [1,2,3,4]   
h1 = sol.lst2link(a1)
print(sol.print(h1))
res = sol.reverseKGroup(h1, 2)
print(sol.print(res)) 