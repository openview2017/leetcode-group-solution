import java.util.Arrays;

public class main0035 {
    public static void main(String[] args) {
        Solution0035 sol = new Solution0035();
        int nums[], target, res;

        nums = new int[]{1,3,5,6};
        target = 5;
        res = sol.searchInsert(nums, target);
        System.out.println(res);
    }
}

class Solution0035 {
    public int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index>=0) {
            return index;
        }
        else {
            return (-(index) - 1);
        }
    }
}