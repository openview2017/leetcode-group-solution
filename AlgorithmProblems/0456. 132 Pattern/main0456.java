public class main0456 {
    public static void main(String[] args) {
        Solution0456 sol = new Solution0456();
        int[] nums = {1,2,3,4};
        boolean res = sol.find132pattern(nums);
        System.out.println(res);
    }
}

class Solution0456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> d = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < k) return true;
            while (!d.isEmpty() && d.peekLast() < nums[i]) {
                // 事实上，k 的变化也具有单调性，直接使用 k = pollLast() 也是可以的
                k = Math.max(k, d.pollLast()); 
            }
            d.addLast(nums[i]);
        }
        return false;
    }
}

//https://leetcode.cn/problems/132-pattern/solution/xiang-xin-ke-xue-xi-lie-xiang-jie-wei-he-95gt/