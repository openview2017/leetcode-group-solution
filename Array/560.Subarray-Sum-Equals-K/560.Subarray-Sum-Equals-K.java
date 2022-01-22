// Solution 1. Brute force. We just need two loops (i, j) and test if SUM[i, j] = k. 
// Time complexity O(n^2), Space complexity O(1). I bet this solution will TLE.  


// Solution 2. From solution 1, we know the key to solve this problem is SUM[i, j].
//  So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j]. 
//  To achieve this, we just need to go through the array, calculate the current sum 
//  and save number of all seen PreSum to a HashMap. Time complexity O(n), Space complexity O(n).

class Solution {   
    // Solution 2:  use PreSum + HashMap
    // https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-%2B-HashMap
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> presumMap = new HashMap<>();
        presumMap.put(0, 1);       
        int sum = 0;
        int count = 0;
       
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];           
            if (presumMap.containsKey(sum - k)) {
                count += presumMap.get(sum - k);
            }
            presumMap.put(sum, presumMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    /* Solution 3: 
    use extra Space O(n), this solution not TLE.
      nums: 1， 1 , 1
                ^
                    ^
        k= 2
        sum[0] = 0
        sum[1] = 1,  sum[2] = 2,  sum[3] = 3
    */ 
    public int subarraySum_ByCumulativeSum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
       
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
       
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (sum[end] - sum[start] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}