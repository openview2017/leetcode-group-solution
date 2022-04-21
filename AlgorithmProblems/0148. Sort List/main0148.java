import java.util.*;

public class main0148 {
    public static void main(String[] args) {
        Solution0148 sol = new Solution0148();
        int[] head;
        ListNode h1;

        head = new int[]{4,2,1,3};
        h1 = sol.intArr2List(head);
        sol.printList(h1);
        h1 = sol.sortList(h1);
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

// merge sort by huahua, https://zxi.mytechroad.com/blog/divide-and-conquer/leetcode-148-sort-list/
class Solution0148 {
    public ListNode sortList(ListNode head) {
      if (head == null || head.next == null) return head;
      ListNode slow = head;
      ListNode fast = head.next;
      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }
      ListNode mid = slow.next;
      slow.next = null;
      return merge(sortList(head), sortList(mid));
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode tail = dummy;
      while (l1 != null && l2 != null) {
        if (l1.val > l2.val) {
          ListNode tmp = l1;
          l1 = l2;
          l2 = tmp;
        }
        tail.next = l1;
        l1 = l1.next;
        tail = tail.next;
      }
      tail.next = (l1 != null) ? l1 : l2;
      return dummy.next;
    }

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
}