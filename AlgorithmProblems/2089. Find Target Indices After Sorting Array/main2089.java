public class main2089 {
    
}
class Solution2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count = 0, lessthan = 0;
        for (int n : nums) {
            if (n == target) count++;
            if (n < target) lessthan++;
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(lessthan++);
        }
        return result;        
    }
}