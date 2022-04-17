import java.util.Arrays;

public class main0912 {
    public static void main(String[] args) {
        Solution0912mergesort solm = new Solution0912mergesort();
        Solution0912quicksort solq = new Solution0912quicksort();
        int[] arr, res;

        arr = new int[]{5,2,3,1};
        System.out.println(Arrays.toString(arr));
        res = solm.sortArray(arr);
        System.out.println(Arrays.toString(res));
        res = solq.sortArray(arr);
        System.out.println(Arrays.toString(res));

    }
}

class Solution0912mergesort { // mergeSort, // 14 - 22, tc: o(nlogn), sc:o(n)
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int[] helper = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, helper);
        return nums;
    }   
    
    private void mergeSort(int[] nums, int left, int right, int[] helper) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, helper);        
        mergeSort(nums, mid + 1, right, helper);
        combine(nums, left, mid, right, helper);
        return;
    }
    
    private void combine(int[] nums, int left, int mid, int right, int[] helper) {
        // 1. copy to cache
        for (int i = left; i <= right; i++) {
            helper[i] = nums[i];
        }
        int l = left, r = mid + 1, idx = left; // idx - nums, l,r - helper
        while (l <= mid && r <= right) {
            if (helper[l] <= helper[r]) {
                nums[idx++] = helper[l++];
            } else {
                nums[idx++] = helper[r++];
            }
        }
        while (l <= mid) {
            nums[idx++] = helper[l++];
        }
        return;
    }
}



class Solution0912quicksort { // 59 quick sort - 06, tc:o()
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot+1, right);
        return;
    }
    
    private int partition(int[] nums, int left, int right) {
        int pivot = left + (int) ((right - left + 1) * Math.random());
        int piVal = nums[pivot];
        swap(nums, pivot, right);
        pivot = left; // [left, pivot) smaller
        for (int i = left; i < right; i++) {
            if (nums[i] <= piVal) {
                swap(nums, i, pivot++);
            }
        }
        swap(nums, pivot, right);
        return pivot;
    }
    
    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}