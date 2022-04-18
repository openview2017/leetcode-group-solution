public class main1658 {
    
}

class Solution1658 {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int n = nums.length;
        int maxi = -1;
        int left = 0;
        int current = 0;

        for (int right = 0; right < n; right++) {
            // sum([left ,..., right]) = total - x
            current += nums[right];
            // if larger, move `left` to left
            while (current > total - x && left <= right) {
                current -= nums[left];
                left += 1;
            }
            // check if equal
            if (current == total - x) {
                maxi = Math.max(maxi, right - left + 1);
            }
        }
        return maxi != -1 ? n - maxi : -1;
    }
}
//https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/