/*
step1: find mid
step2: reverse second part
step3: merge

*/
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        ListNode mid = findMid(head);
        ListNode secondHead = reverse(mid.next);
        mid.next = null;
        
        merge(head, secondHead);
    }
    private ListNode findMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    private void merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (one != null && two != null) {
            cur.next = one;
            one = one.next;
            cur = cur.next;
            
            cur.next = two;
            two = two.next;
            cur = cur.next;
        }
        if (one == null) {
            cur.next = two;
        } else {
            cur.next = one;
        }
    }
}