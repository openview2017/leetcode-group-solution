class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }
}

/*
 1 1 1 1 1 3 1
         s
             f
s: 0..s-1, to keep
f: to be explored


*/