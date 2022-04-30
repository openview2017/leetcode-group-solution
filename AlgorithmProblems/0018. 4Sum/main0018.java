import java.util.*;

public class main0018 {
    public static void main(String[] args) {
        Solution0018 sol = new Solution0018();
        int nums[], target;
        List<List<Integer>> res;

        nums = new int[]{1,0,-1,0,-2,2};
        target = 0;
        res = sol.fourSum(nums, target);
        System.out.println(Arrays.deepToString(res.toArray()));
        
        nums = new int[]{2,2,2,2,2};
        target = 8;
        res = sol.fourSum(nums, target);
        System.out.println(Arrays.deepToString(res.toArray()));
    }
}



class Solution0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length)
            return res;
        if (k == 2)
            return twoSum(nums, target, start);
        for (int i = start; i < nums.length; ++i)
            if (i == start || nums[i - 1] != nums[i]) //dedup
                for (List<Integer> set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(set);
                }
        return res;
    }
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for (int i = start; i < nums.length; ++i) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i])
                if (s.contains(target - nums[i]))
                    res.add(Arrays.asList(target - nums[i], nums[i]));
            s.add(nums[i]);
        }
        return res;
    }
}