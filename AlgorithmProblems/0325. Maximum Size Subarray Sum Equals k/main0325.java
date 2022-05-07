import java.util.*;

public class main0325 {
    public static void main(String[] args) {
        Solution0325 sol = new Solution0325();
        int nums[], k, res;
        
        nums = new int[]{1,-1,5,-2,3};
        k = 3;
        res = sol.maxSubArrayLen(nums, k);
        System.out.println(res);         
    }
}

class Solution0325 { // 12 - 17
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> preSumIdx = new HashMap<>();
        int longest = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                longest = Math.max(longest, i + 1);
            }
            if (preSumIdx.containsKey(sum - k)) { // (idx, i]
                longest = Math.max(longest, i - preSumIdx.get(sum - k));
            }
            if (!preSumIdx.containsKey(sum)) {
                preSumIdx.put(sum, i);
            }
        }
        return longest;
    }
}