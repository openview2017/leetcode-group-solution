public class main0055 {
    
}

class Solution0055 { 
    public boolean canJump(int[] nums) {
        int cur = 0, farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > cur) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]); // i not cur
            if (farthest >= nums.length - 1) {
                return true;
            }
            if (i == cur) {
                cur = farthest;
            }
        }
        return true;
    }
    
    //tc:o(n2), sc:o(n)
    public boolean canJump0(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}