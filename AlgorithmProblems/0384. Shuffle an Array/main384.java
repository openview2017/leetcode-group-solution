import java.util.Arrays;

public class main384 {
    public static void main(String[] args) {
        Solution384 sol = new Solution384(new int[]{1, 2, 3});
        sol.print(); 
        sol.shuffle(); sol.print();
        sol.reset();
        sol.print();
        sol.shuffle();
        sol.print();

    }
}



class Solution384 {
    int[] nums, orig;
    
    public Solution384(int[] nums) {
        this.nums = nums;
        this.orig = nums.clone();
    }
    
    public int[] reset() {
        this.nums = orig;
        this.orig = nums.clone();
        return nums;
    }
    
    public int[] shuffle() {
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            int nextIndex = (int) (Math.random() * (i + 1));
            swap(nums, i, nextIndex);
        }
        return nums;
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void print() {
        System.out.println(Arrays.toString(nums));
    }
}

/**
tc: o(n!), sc: o(n) n - length of array
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */