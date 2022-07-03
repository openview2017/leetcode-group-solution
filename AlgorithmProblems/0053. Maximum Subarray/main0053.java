public class main0053 {
    
}

class Solution0053 {
    public int maxSubArray(int[] nums) {
        int glbmx = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // if (cur < 0) {
            //     cur = nums[i];
            // } else {
            //     cur = cur + nums[i];
            // }
            cur = Math.max(cur + nums[i], nums[i]); // Kodane
            glbmx = Math.max(glbmx, cur);
        }
        return glbmx;
    }
}