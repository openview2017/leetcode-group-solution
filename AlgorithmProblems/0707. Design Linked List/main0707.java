public class main0707 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        System.out.println(myLinkedList.get(1));              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        System.out.println(myLinkedList.get(1));              // return 3
    }
}

class MyLinkedList { // by huahua
    class Node {
      public int val;
      public Node next;
      public Node(int val) { this.val = val; this.next = null; }
      public Node(int val, Node next) { this.val = val; this.next = next; }
    }
    
    private Node head;
    private Node tail;
    private int size;
    
    public MyLinkedList() {
      this.head = this.tail = null;
      this.size = 0;
    }
    
    private Node getNode(int index) {
      Node n = new Node(0, this.head);
      while (index-- >= 0) {
        n = n.next;
      }
      return n;
    }
   
    public int get(int index) {
      if (index < 0 || index >= size) return -1;
      return getNode(index).val;
    }
   
    public void addAtHead(int val) {
      this.head = new Node(val, this.head);
      if (this.size++ == 0)
        this.tail = this.head;    
    }
   
    public void addAtTail(int val) {
      Node n = new Node(val);
      if (this.size++ == 0)
        this.head = this.tail = n;
      else
        this.tail = this.tail.next = n;
    }
   
    public void addAtIndex(int index, int val) {
      if (index < 0 || index > this.size) return;
      if (index == 0)  { this.addAtHead(val); return; }
      if (index == size) { this.addAtTail(val); return; }
      Node prev = this.getNode(index - 1);
      prev.next = new Node(val, prev.next);
      ++this.size;
    }
   
    public void deleteAtIndex(int index) {
      if (index < 0 || index >= this.size) return;
      Node prev = this.getNode(index - 1);
      prev.next = prev.next.next;
      if (index == 0) this.head = prev.next;
      if (index == this.size - 1) this.tail = prev;
      --this.size;
    }
  }