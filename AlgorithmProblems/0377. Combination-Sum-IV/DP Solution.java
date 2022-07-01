class Solution {
    public int combinationSum4(int[] nums, int target) {
        // corner case check
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= target; i++) {  // i represents the target so far
            for (int j = 0; j < nums.length; j++) { // j represents the index of the current nums, so we have 0...j index values
                if (i >= nums[j]) {
                    dp[i]+= dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}

/*
dp
TC: O(n^2)
SC: O(n)

*/