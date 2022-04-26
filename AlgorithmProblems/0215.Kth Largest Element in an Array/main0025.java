import java.util.Arrays;

public class main0025 {
    public static void main(String[] args) {
        solution0025 sol = new solution0025();
        int nums[], k, res;

        nums = new int[]{3,2,1,5,6,4};
        k = 2;
        res = sol.findKthLargest(nums, k);
        System.out.println("Input : " + Arrays.toString(nums));
        System.out.println("k : " + k);
        System.out.println("result : " + res);

    }
}

// optimal solution inspired by Linghan
class solution0025 {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            mid = partition(nums, mid, left, right);
            if (mid == nums.length - k) {
                return nums[mid];
            } else if (mid < nums.length - k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[mid];
    }
    
    private int partition(int[] nums, int pivot, int from, int to) {
        int piVal = nums[pivot];
        swap(nums, pivot, to);
        int idx = from;
        for (int i = from; i < to; i++) {
            if (nums[i] < piVal) {
                swap(nums, i, idx++);
            }
        }
        swap(nums, idx, to);
        return idx;
    }
    
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }    
}