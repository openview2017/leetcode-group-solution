public class main1438 {
    public static void main(String[] args) {
        Solution1438 sol = new Solution1438();
        int[] nums = {8,2,4,7};
        int limit = 4;
        res = sol.longestSubarray(nums, limit);
        System.out.println(res);
    }
}

class Solution1438 { //tc/sc:o(n)
    public int longestSubarray(int[] nums, int limit) { // monostack
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int res = 1;
        int l = 0;
        // find the longest subarray for every right pointer by shrinking left pointer
        for (int r = 0; r < nums.length; ++r) {
            // update maxDeque with new right pointer
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[r]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(nums[r]);

            // update minDeque with new right pointer
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[r]) {
                minDeque.removeLast();
            }
            minDeque.addLast(nums[r]);

            // shrink left pointer if exceed limit
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[l]) maxDeque.pollFirst();
                if (minDeque.peekFirst() == nums[l]) minDeque.pollFirst();
                ++l;  // shrink it!
            }

            // update res
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
    public int longestSubarray0(int[] nums, int limit) { // tle
        int longest = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int max = nums[i], min = nums[i];
            for (int j = i; j < n; j++) {
                max = Math.max(nums[j], max);                
                min = Math.min(nums[j], min);
                if (max - min <= limit) {
                    longest = Math.max(longest, j - i + 1);
                }            
            }
        }
        return longest;
    }
}