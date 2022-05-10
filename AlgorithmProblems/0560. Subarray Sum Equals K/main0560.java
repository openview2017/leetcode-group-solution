import java.util.*;

public class main0560 {
    public static void main(String[] args) {
        Solution0560 sol = new Solution0560();
        int nums[], k, res;
        
        nums = new int[]{1,1,1};
        k = 2;
        res = sol.subarraySum(nums, k);
        System.out.println(res);       
    }
}

class Solution0560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumFreq = new HashMap<>();
        sumFreq.put(0, 1);
        int count = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            count += sumFreq.getOrDefault(sum - k, 0);
            sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

/*abstract: if all positive
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int left = 0, right = 0; // [left, right]
        int len = nums.length;
        int curSum = 0;
        while (right < len) {
            curSum += nums[right];
            if (curSum == k) {
                count++;
            } 
            while (curSum > k && left <= right) {
                curSum -= nums[left++];
                if (curSum == k) {
                    count++;
                }
            }
            right++;
        }
        return count;
    }
*/