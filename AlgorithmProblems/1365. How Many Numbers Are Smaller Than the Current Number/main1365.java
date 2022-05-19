public class main1365 {
    
}


class Solution1365 { // 23
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101]; // count[i] # appearance <= i
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i <= 100; i++) {
            count[i] += count[i-1];
        }
        int[] res = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) { //!!!!!!!!!!!!
                res[j] = 0;
            } else {
                res[j] = count[nums[j]- 1] ; // !!!!!!!!!!!
            }
        }
        return res;
    }
}// tc/sc: o(N)
// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/discuss/524996/JAVA-beats-100-O(n)
