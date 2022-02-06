import java.util.Arrays;

/*
209. Minimum Size Subarray Sum
Medium

Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Method: 2 pointer

*/
public class main0209 {
    public static void main(String[] args) {
        int[] nums;
        int target, res;
        Solution0209 sol = new Solution0209();

        target = 7;
        nums = new int[]{2,3,1,2,4,3};
        res = sol.minSubArrayLen(target, nums);
        System.out.println(Arrays.toString(nums) + ", target = " +  target);
        System.out.println(res);
        
        target = 4;
        nums = new int[]{1,4,4};
        res = sol.minSubArrayLen(target, nums);
        System.out.println(Arrays.toString(nums) + ", target = " +  target);
        System.out.println(res);
                
        target = 11;
        nums = new int[]{1,1,1,1,1,1,1,1};
        res = sol.minSubArrayLen(target, nums);
        System.out.println(Arrays.toString(nums) + ", target = " +  target);
        System.out.println(res);
    }
}


class Solution0209 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res != Integer.MAX_VALUE ? res : 0; 
    }
}