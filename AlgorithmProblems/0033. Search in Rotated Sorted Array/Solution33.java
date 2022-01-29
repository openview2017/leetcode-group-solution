import java.util.Arrays;

public class Solution33 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr;
        int target;
        
        arr = new int[]{4,5,6,7,0,1,2};
        target = 0;
        sol = new Solution(arr, target);
        sol.printResult();
        
        arr = new int[]{4,5,6,7,0,1,2};
        target = 3;
        sol = new Solution(arr, target);
        sol.printResult();
        
        arr = new int[]{1};
        target = 0;
        sol = new Solution(arr, target);
        sol.printResult();
    }
}


class Solution { // 02
    int[] nums;
    int target;
    Solution() {}
    
    public Solution(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }
    
    public void indexRef() {
        int len = nums.length;
        int[] indicies = new int[len];
        for (int i = 0; i < len; i++) {
            indicies[i] = i;
        }
        System.out.println(Arrays.toString(indicies));
    }
    
    public void printResult() {
        indexRef();
        System.out.println(Arrays.toString(nums));
        System.out.println("Target : " + target);
        System.out.println("Index Found : " + search(nums, target));  
        System.out.println();        
    }
    
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        int mid;
        while (lo < hi - 1) {
            mid = lo + (hi - lo) / 2;
            // if you use double side binary search protocol
            if (nums[lo] == target) {
                return lo;
            } else if (nums[hi] == target) {
                return hi;
            } else if (nums[mid] == target) {
                return mid;
            }
            // boundary must be check to avoid error, e.g. [1,2,3], target 1
            if (nums[mid] > nums[lo]) { // left mono-increasing
                if (target > nums[lo] && target < nums[mid]) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            } else {
                if (target > nums[mid] && target < nums[hi]) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
        }
        if (nums[lo] == target) {
            return lo;
        }
        if (nums[hi] == target) {
            return hi;
        }
        return -1;
    }
}