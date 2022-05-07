public class main1099 {
    public static void main(String[] args) {
        Solution sol = new Solution1099();
        int nums[], k, res;
        
        nums = new int[]{34,23,1,24,75,33,54,8};
        k = 60;
        res = sol.twoSumLessThanK(nums, k);
        System.out.println(res);
    }
}


class Solution1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int answer = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                answer = Math.max(answer, sum);
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }
}