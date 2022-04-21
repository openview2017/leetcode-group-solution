# https://zxi.mytechroad.com/blog/list/leetcode-707-design-linked-list/

class Node:
  def __init__(self, val, _next=None):
    self.val = val
    self.next = _next
    
class MyLinkedList:  
  def __init__(self):
    self.head = self.tail = None
    self.size = 0
  
  def getNode(self, index):
    n = Node(0, self.head)
    for i in range(index + 1):
      n = n.next
    return n
    
  def get(self, index):
    if index < 0 or index >= self.size: return -1
    return self.getNode(index).val
 
 
  def addAtHead(self, val):
    n = Node(val, self.head)
    self.head = n
    if self.size == 0:
      self.tail = n
    self.size += 1
 
 
  def addAtTail(self, val):
    n = Node(val)
    if self.size == 0:
      self.head = self.tail = n
    else:
      self.tail.next = n
      self.tail = n
    self.size += 1
 
  def addAtIndex(self, index, val):
    if index < 0 or index > self.size: return
    if index == 0: return self.addAtHead(val)
    if index == self.size: return self.addAtTail(val)
    prev = self.getNode(index - 1)
    n = Node(val, prev.next)
    prev.next = n
    self.size += 1
 
 
  def deleteAtIndex(self, index):
    if index < 0 or index >= self.size: return
    prev = self.getNode(index - 1)
    prev.next = prev.next.next
    if index == 0: self.head = prev.next
    if index == self.size - 1: self.tail = prev
    self.size -= 1

myLinkedList = MyLinkedList()
myLinkedList.addAtHead(1)
myLinkedList.addAtTail(3)
myLinkedList.addAtIndex(1, 2)    # linked list becomes 1->2->3
print(myLinkedList.get(1))            # return 2
myLinkedList.deleteAtIndex(1)    # now the linked list is 1->3
print(myLinkedList.get(1))              # return 3