import java.util.*;
import java.util.function.BiPredicate;

public class main2104 {
    public static void main(String[] args) {
        Solution2104 sol = new Solution2104();
        int[] nums = new int[]{1,2,3};
        long res = sol.subArrayRanges(nums);
        System.out.println(res);
    }
}


class Solution2104 { // 08
    public long subArrayRanges(int[] nums) {
        return getExSums(nums, (i1,i2)->(i1>i2)) - getExSums(nums, (i1,i2)->(i2>i1));
    }
    
    private long getExSums(int[] nums, BiPredicate<Integer, Integer> comp) {
        Deque<Integer> stack = new ArrayDeque<>();
        long res = 0;
        for (int i = 0; i <= nums.length; i++) {
            while (!stack.isEmpty() && (i == nums.length || comp.test(nums[i], nums[stack.peekLast()]))) { //comp.test !!!
                int pivot = stack.pollLast(), val = nums[pivot], left = stack.isEmpty() ? -1 : stack.peekLast();
                res += (long)val * (i - pivot) * (pivot - left);
            }
            stack.offerLast(i);
        }
        return res;
    }
}