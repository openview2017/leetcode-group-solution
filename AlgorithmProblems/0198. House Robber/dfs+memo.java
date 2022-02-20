/*
recursion
TC: O(n)
SC: O(n)
*/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return helper(nums, memo, 0);

    }
    private int helper(int[] nums, int[] memo, int index) {
        if (index >= nums.length) {
            return 0;
        }
        
        if (memo[index] > -1) {
            return memo[index];
        }
        
        int rob = nums[index] + helper(nums, memo, index + 2);
        int notRob = helper(nums, memo, index + 1);
        int res = Math.max(rob, notRob);
        memo[index] = res;
        return res;
    }
}