/*

虽然不难，但是总结几个点：=，容易忽略。
while loop里面是||，会好做做很多
判断l1和l2不为null，分别判断，分别往sum里加
while loop的条件里还有sum!= 0，为||,这样，最后就算listnode走完了，如果sum还么结束，就能再加一个node



*/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode cur = dummy;
      int sum = 0;
  
      while (l1 != null || l2 != null || sum != 0) {
  
        if (l1 != null) {
          sum += l1.val;
          l1 = l1.next;
        }
        if (l2 != null) {
          sum += l2.val;
          l2 = l2.next;
        }
        ListNode node = new ListNode(sum % 10);
        cur.next = node;
        cur = cur.next;
        sum = sum / 10;
      }
      return dummy.next;
    }
  }
  