/*
TC: O(logn)
SC: O(1)
*/
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }     
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) { // 等于
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; //找不到就return -1
    }
}