import java.util.*;

public class main0445 {
    public static void main(String[] args) {
        Solution0445 sol = new Solution0445();
        int[] l1, l2;
        ListNode h1, h2, res;
        
        l1 = new int[]{7,2,4,3};
        l2 = new int[]{5,6,4};
        h1 = sol.intArr2List(l1);
        h2 = sol.intArr2List(l2);
        res = sol.addTwoNumbers(h1, h2);
        sol.printList(res);     

        l1 = new int[]{2,4,3};
        l2 = new int[]{5,6,4};
        h1 = sol.intArr2List(l1);
        h2 = sol.intArr2List(l2);
        res = sol.addTwoNumbers(h1, h2);
        sol.printList(res);
    }
}

class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution0445 {
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
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        while (head != null) {
            // keep the next node
            ListNode tmp = head.next;
            // reverse the link
            head.next = last;
            // update the last node and the current node
            last = head;
            head = tmp;    
        }    
        return last;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse lists
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        
        ListNode head = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            // get the current values 
            int x1 = l1 != null ? l1.val : 0;
            int x2 = l2 != null ? l2.val : 0;
            
            // current sum and carry
            int val = (carry + x1 + x2) % 10;
            carry = (carry + x1 + x2) / 10;
            
            // update the result: add to front
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;
            
            // move to the next elements in the lists
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry != 0) {
            ListNode curr = new ListNode(carry);
            curr.next = head;
            head = curr;
        }

        return head;
    }
}