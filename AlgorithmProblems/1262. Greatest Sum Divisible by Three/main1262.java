public class main1262 {
    
}

class Solution1262 {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][3];
        dp[0][0] = 0;
        dp[0][1] = dp[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] % 3 == 0) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][0] + nums[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][1] + nums[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][2] + nums[i - 1]);
            } else if (nums[i - 1] % 3 == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] + nums[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + nums[i - 1]);
            } else if (nums[i - 1] % 3 == 2) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] + nums[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + nums[i - 1]);
            }
        }
        return dp[n][0];
    }

    // public int maxSumDivThree(int[] nums) {
    //     return maxSumDivK(nums,3);
    // }
    // public int maxSumDivK(int[] nums, int k){
    //     if(k==0) return -1;
    //     int[] dp = new int[k];
    //     int[][] d2p = new int[2][k];
    //     int idx = 0;
    //     for(int num : nums){
    //         int tmp[] = Arrays.copyOf(dp,k);
    //         //d2p[1-idx] = Arrays.copyOf(dp,k);
    //         for(int i=0;i<k;i++){
    //             dp[(num+tmp[i])%k] = Math.max(dp[(num+tmp[i])%k],num+tmp[i]); 
    //             // d2p[idx][(num+d2p[1-idx][i])%k] = Math.max(d2p[idx][(num+d2p[1-idx][i])%k],num+d2p[1-idx][i]);
    //         }
    //         // idx = 1 - idx;
    //     }
    //     return dp[0];
    //      // return d2p[idx][0];
    // }
}