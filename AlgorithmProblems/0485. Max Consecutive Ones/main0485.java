public class main0485 {
    public static void main(String[] args) {
        Solution485 sol = new Solution485();
        int count, nums[];
        
        nums = new int[]{1,1,0,1,1,1};
        count = sol.findMaxConsecutiveOnes(nums);
        System.out.println(count);
    }
}

class Solution485 { // 20 - 21
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cur = 0;
            } else {
                cur++;
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}