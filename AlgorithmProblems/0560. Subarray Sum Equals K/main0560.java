public class main0560 {
    
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
