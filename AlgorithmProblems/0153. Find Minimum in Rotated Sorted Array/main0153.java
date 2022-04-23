import java.util.Arrays;

public class main0153 {
    public static void main(String[] args) {
        Solution0153 sol = new Solution0153();
        int nums[], res;
        
        nums = new int[]{3,4,5,1,2};
        res = sol.findMin(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
    }
}


class Solution0153 {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
    public int findMin0(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int start = 0, end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (start < num.length) {
            return num[start];
        }
        return -1;
    }
}
