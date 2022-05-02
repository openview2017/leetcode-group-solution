public class main1696 {
    
}


class Solution1696 {
    // best method: dp + compressed deque. tc: o(N), sc: o(n)
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int score = nums[0];
        Deque<int[]> dq = new LinkedList<>();
        dq.offerLast(new int[] { 0, score });
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (dq.peekFirst() != null && dq.peekFirst()[0] < i - k) {
                dq.pollFirst();
            }
            score = dq.peek()[1] + nums[i];
            // pop the smaller value
            while (dq.peekLast() != null && score >= dq.peekLast()[1]) {
                dq.pollLast();
            }
            dq.offerLast(new int[] { i, score });
        }
        return score;
    }
    // method 1: priority queue, tc: o(nlogn), sc: o(n)
    public int maxResult_01(int[] nums, int k) {
        int len = nums.length;
        Queue<Integer> maxheap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(int i1, int i2) {
                return nums[i2] - nums[i1];
            }
        });
        int res = nums[1];
        for (int i = 1; i < len; i++) {
            while (maxheap.peek() >= i - k) {
                maxheap.poll();
            }
            
            maxheap.add(i);
        }
        return res;
    }
}

class Solution {

}