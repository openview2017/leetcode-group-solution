public class main0300 {
    
}


class Solution0300 {
    public int lengthOfLIS(int[] nums) {
        int[] minends = new int[nums.length];
        int endidx = 0; // [0, endidx)
        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = endidx, mid = 0; // first idx greater than nums[i]
            while (left < right) {
                mid = left + (right - left) / 2;
                if (minends[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            minends[left] = nums[i];
            if (endidx == right) endidx++;
        }
        return endidx;
    }
}

/*
  0 1 2 3 4 5 6   7
[10,9,2,5,3,7,101,18]

*/