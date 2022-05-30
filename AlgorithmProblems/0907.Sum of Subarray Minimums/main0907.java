public class main0907 {
    public static void main(String[] args) {
        Solution0907 sol = new Solution0907();
        int[] arr = new int[]{3,1,2,4};
        int res = sol.sumSubarrayMins(nums);
        System.out.println(res);
    }
}

class Solution0907 {
    public int sumSubarrayMins(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        long sums = 0;
        int M = (int) 1e9+7;
        for (int i = 0; i <= nums.length; i++) {
            while (!stack.isEmpty() && (i == nums.length || nums[stack.peekLast()] >= nums[i])) {
                int pivot = stack.pollLast(), val = nums[pivot];
                int left = stack.isEmpty() ? -1 : stack.peekLast();
                sums = (sums + (long) (i - pivot) * (pivot - left) * val) % M;
            }
            stack.offerLast(i);
        } 
        return (int)sums;
    }
}