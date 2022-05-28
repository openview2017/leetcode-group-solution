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


class Solution1365_2 { // 38 - 40
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> rank = new HashMap<>();
        int[] arr = nums.clone();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            rank.putIfAbsent(arr[i], i); // put doesn't work for duplicate case
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = rank.get(nums[i]);
        }
        return res;
    }
} // tc: o(nlogn), sc: o(n)
https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/discuss/535421/Java-Clean-HashMap-solution-with-explanation