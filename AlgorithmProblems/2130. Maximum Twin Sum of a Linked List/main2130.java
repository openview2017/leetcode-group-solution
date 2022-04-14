import java.util.Arrays;

public class main2130 {
    public static void main(String[] args) {
        Solution2130 sol = new Solution2130();
        ListNode head;
        int maxPairSum;
        int[] arr;

        arr = new int[]{5,4,2,1};
        head = sol.convList(arr);
        maxPairSum = sol.pairSum(head);
        System.out.println(Arrays.toString(arr));
        System.out.println(maxPairSum);

        arr = new int[]{4,2,2,3};
        head = sol.convList(arr);
        maxPairSum = sol.pairSum(head);
        System.out.println(Arrays.toString(arr));
        System.out.println(maxPairSum);

        arr = new int[]{1,100000};
        head = sol.convList(arr);
        System.out.println(Arrays.toString(arr));
        maxPairSum = sol.pairSum(head);
        System.out.println(maxPairSum);
    }
}

class Solution2130 {
    protected ListNode convList(int[] arr) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        for (int x : arr) {
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        return dum.next;
    }
    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return head.val;
        }
        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        right = reverse(right);
        return maxSum(left, right);
    }

    private int maxSum(ListNode left, ListNode right) {
        int maxVal = Integer.MIN_VALUE;
        while (left != null) {
            maxVal = Math.max(maxVal, left.val + right.val);
            left = left.next;
            right = right.next;
        }
        return maxVal;
    }

    private ListNode reverse(ListNode head) {
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
        return prev;
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = head;
        ListNode f = head.next;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}