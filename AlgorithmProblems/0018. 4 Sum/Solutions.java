class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    // start is the start index of search space
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (start == nums.length) {
            return res;
        }

        int averageVal = target / k;
        if (nums[start] > averageVal || nums[nums.length - 1] < averageVal) {
            return res;
        }

        // base case
        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; i++) {
            // skip repeated elements
            if (i == start || nums[i] != nums[i - 1]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }
        return res;
    }


    // this nums[] is sorted since this API is called after Arrays.sort()
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        // use two pointers
        int i = start, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] < target || i > start && nums[i] == nums[i - 1]) {
                i++;
            } else if (nums[i] + nums[j] > target || j < nums.length - 1 && nums[j] == nums[j + 1]) {
                j--;
            } else {
                res.add(Arrays.asList(nums[i], nums[j]));
                i++;
                j--;
            }
        }
        return res;
    }
}

/*
Arrays.sort(): O(nlogn)
twoSum(): two pointers: TC: O(n), SC: O(1)
3sum: O(n^2),
kSum: O(n^(k-1))
total TC: O(n^(k-1))

SC:
twoSum: O(1)
Arrays.sort(): O(logn)
recursion: O(k + logn)
*/