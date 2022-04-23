public class main0081 {
    public static void main(String[] args) {
        int[] nums;
        int target;
        boolean res;
        Solution0081 sol = new Solution0081();

        nums = new int[]{2,5,6,0,0,1,2};
        target = 0;
        res = sol.search(nums, target);
        System.out.println(res);
    }
}


class Solution0081 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[left]) { // mono increasing left
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[left] > nums[mid]) { // mono increasing right; xxxxxx(nums[right] > nums[mid])
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                left++;
            }
        }
        return false;
    }
}