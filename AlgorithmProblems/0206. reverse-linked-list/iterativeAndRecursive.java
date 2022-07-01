class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse2(head);
    }
    
    //Iteratively
    private ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            
            prev = head;
            head = next;
        }
        return prev; //注意这里return的是prev
    }
    
    //Recursively
    private ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode N1 = head;
        ListNode N2 = head.next;
        
        ListNode newHead = reverse2(N2);
        N2.next = N1;
        N1.next = null;
        return newHead;
    }

}