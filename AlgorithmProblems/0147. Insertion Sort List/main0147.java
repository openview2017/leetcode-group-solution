import java.util.*;

public class main0147 { // 35
    public static void main(String[] args) {
        Solutoin0147 sol = new Solutoin0147();
        int[] head;
        ListNode h1;

        head = new int[]{4,2,1,3};
        h1 = sol.intArr2List(head);
        sol.printList(h1);
        h1 = sol.insertionSortList(h1);
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

class Solutoin0147 { // 29
    //
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
        ListNode curr = head;
        while (curr != null) {
            res.add(curr.val);
            curr = curr.next;
        }
        System.out.println(Arrays.toString(res.toArray()));
    }

    
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode sortedEnd = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val >= sortedEnd.val) {
                sortedEnd = sortedEnd.next;
            } else {
                ListNode prev = dum;
                while (prev.next != null && prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                
                sortedEnd.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = sortedEnd.next;
        }
        return dum.next;
    }
}
// reference: https://leetcode-cn.com/problems/insertion-sort-list/solution/dui-lian-biao-jin-xing-cha-ru-pai-xu-by-leetcode-s/