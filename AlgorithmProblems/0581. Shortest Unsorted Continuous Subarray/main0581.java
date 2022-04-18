import java.util.Arrays;

/*
581. Shortest Unsorted Continuous Subarray
Medium

Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0

*/

public class main0581 {
    public static void main(String[] args) {
        Solution581 sol = new Solution581();
        int[] nums;
        int res;

        nums = new int[]{2,6,4,8,10,9,15};
        res = sol.findUnsortedSubarray(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
        
        nums = new int[]{1,2,3,4};
        res = sol.findUnsortedSubarray(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
                
        nums = new int[]{1};
        res = sol.findUnsortedSubarray(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
    }
}


class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int end = 0, begin = -1;
        int len = nums.length;
        int max = nums[0], min = nums[len - 1];
        
        for (int i = 0; i < len; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                end = i;
            }
            
            if (nums[len - 1 - i] <= min) {
                min = nums[len - 1 - i];
            } else {
                begin = len - 1 - i;
            }
        }
        if (begin == -1) return 0;
        return end - begin + 1;
    }
}
/*abstract
https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/si-lu-qing-xi-ming-liao-kan-bu-dong-bu-cun-zai-de-/
*/