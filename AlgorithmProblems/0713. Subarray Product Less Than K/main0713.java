public class main0713 {
    
}

class Solution0713 { // 49 - 58
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0; // [left, right]
        int curProd = 1;
        int n = nums.length;
        int count = 0;
        while (right < n) {
            curProd *= nums[right];
            while (left <= right && curProd >= k) {
                curProd /= nums[left++];
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
}