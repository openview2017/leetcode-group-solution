import java.util.*;

public class main1696 {
    public static void main(String[] args) {
        int k, nums[], res;
        Solution1696 sol = new Solution1696();

        nums = new int[]{1,-1,-2,4,-7,3};
        k = 2;
        res = sol.maxResult(nums, k);
        System.out.println(res);
        
        nums = new int[]{10,-5,-2,4,0,3};
        k = 3;
        res = sol.maxResult(nums, k);
        System.out.println(res);

        nums = new int[]{1,-5,-20,4,-1,3,-6,-3};
        k = 2;
        res = sol.maxResult(nums, k);
        System.out.println(res);
    }
}


class Solution1696 {
    // best method: dp + compressed deque. tc: o(N), sc: o(n)
    public int maxResult_2(int[] nums, int k) {
        int n = nums.length;
        int score = nums[0];
        Deque<int[]> dq = new LinkedList<>();
        dq.offerLast(new int[] { 0, score });
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (dq.peekFirst() != null && dq.peekFirst()[0] < i - k) {
                dq.pollFirst();
            }
            score = dq.peekFirst()[1] + nums[i];
            // pop the smaller value
            while (dq.peekLast() != null && score >= dq.peekLast()[1]) {
                dq.pollLast();
            }
            dq.offerLast(new int[] { i, score });
        }
        return score;
    }
    // Zhao's common solution:
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len];
        Deque<Integer> idxstack = new ArrayDeque<>();
        idxstack.offerLast(0);
        dp[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // 1. remove obsolete
            while (!idxstack.isEmpty() && i - idxstack.peekFirst() > k) { // !!! not >=
                idxstack.pollFirst();
            }
            // 2. update the dp
            dp[i] = dp[idxstack.peekFirst()] + nums[i];
            
            // 3. remove the non-max
            while (!idxstack.isEmpty() && dp[i] >= dp[idxstack.peekLast()]) {
                idxstack.pollLast();
            }
            idxstack.offerLast(i);
        }
        System.out.println(Arrays.toString(dp));
        return dp[len-1];
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