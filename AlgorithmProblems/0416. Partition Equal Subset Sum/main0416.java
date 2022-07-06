public class main0416 {
    public static void main(String[] args) {
        Solution0416 sol = new Solution0416();
        int[] nums;
        boolean res;

        nums = new int[]{1,5,11,5};
        res = sol.canPartition(nums);
        System.out.println(res);
    }
}


class Solution0416 {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0)
            return false;
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        boolean dp[] = new boolean[subSetSum + 1];
        dp[0] = true;
        for (int curr : nums) {
            for (int j = subSetSum; j >= curr; j--) {
                dp[j] |= dp[j - curr];
            }
        }
        return dp[subSetSum];
    }
}