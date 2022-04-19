public class main0023 {
    
}

class Solution0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode rst = new ListNode();
        ListNode cur = rst;
        int len = lists.length;
        if (len == 0) {
            return null;
        } else if (len == 1) {
            return lists[0];
        }
        // PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(len, new Comparator<ListNode>(){
        //     @Override
        //     public int compare(ListNode L1, ListNode L2) {
        //         if (L1.val == L2.val) {
        //             return 0;
        //         }
        //         return L1.val < L2.val ? -1 : 1;
        //     }
        // });
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((l1, l2)-> l1.val - l2.val);
        // initialization
        for (int i = 0; i < len; i++) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);     
            }
        }
        // pop
        while (!minHeap.isEmpty()) {
            ListNode tmp = minHeap.poll();
            if (tmp.next != null) {
                minHeap.offer(tmp.next);
            }
            cur.next = tmp;
            cur = cur.next;
            cur.next = null;
        }
        
        // return
        return rst.next;
    }
}
// row, col
// tc: row*col*log(row)
// 3:1,1  (3-1)/2, 3/2 nums1[nums1.length / 2] + 
// 4:1,2->(4-1)/2, 4/2