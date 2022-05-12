public class main0523 {
    public static void main(String[] args) {
        Solution0523 sol = new Solution0523();

        int nums[], k;
        nums = new int[]{23,2,4,6,7};
        k = 6
    }
}

class Solution0523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > (); // rem, index
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;                
            }

            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;                    
                }
            } else {
                map.put(sum, i);                
            }
        }
        return false;
    }   
}