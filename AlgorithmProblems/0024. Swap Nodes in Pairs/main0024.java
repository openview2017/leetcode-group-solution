import java.util.*;

public class main0024 {
    public static void main(String[] args) {
        Solution0024 sol = new Solution0024();
        int[] head;
        ListNode h1;

        head = new int[]{1,2,3,4};
        h1 = sol.intArr2List(head);
        sol.printList(h1);
        h1 = sol.swapPairsI(h1);        
        sol.printList(h1);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution0024 {
    public ListNode intArr2List(int[] arr) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        for (int x : arr) {
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        return dum.next;
    }
    public void printList(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        System.out.println(Arrays.toString(res.toArray()));
    }
    public ListNode swapPairs(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }
    
    
    public ListNode swapPairsI(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode cur, prev;
        prev = dum;
        cur = head;
        while (cur != null && cur.next != null) {
            prev.next = cur.next;
            prev = cur;
            cur = cur.next.next;
            prev.next.next = prev;
        }
        prev.next = cur;
        return dum.next;
    }
    
    public ListNode swapPairsII(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }
}