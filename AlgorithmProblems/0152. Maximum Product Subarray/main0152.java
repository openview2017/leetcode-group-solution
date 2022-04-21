public class main0152 {
    public static void main(String[] args) {
        
    }
}


class Solution0152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int result = max;
        
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int tmp_max = Math.max(cur, Math.max(min * cur, max * cur));
            min = Math.min(cur, Math.min(min * cur, max * cur));
            max = tmp_max;
            result = Math.max(max, result);
        }
        return result;
    }
}