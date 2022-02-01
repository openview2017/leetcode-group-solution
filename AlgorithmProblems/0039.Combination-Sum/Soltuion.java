/*
Input: 
    int[] candidate
    int target
Output: 
    all combinations can sum up to the target, in candidates, the digits are unique; 
    in the result, candidate can be used multiple times

DFS:
一共有n层，n是input array的长度，每一层代表一个数字；
每一层代表用几个当前这一层的数字，0...m个
TC： (target/min of candidate)^n
SC: n for the recursion call stack

*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, cur, res, 0); // 0 is the index, starting from 0
        return res;
    }
    private void helper(int[] candidates, int target, List<Integer> cur, List<List<Integer>> res,int index) {
        // base case
        if (index == candidates.length) {
            if (target == 0) {
                res.add(new ArrayList(cur));
            }
            return;
        }
        // recursion rule
        // case 1: not to add the current level
        helper(candidates, target, cur, res,  index + 1);

        // case 2: add current level candidate, add from 1 to multiple times
        int curValue = candidates[index];
        int size = cur.size();

        while (target >= curValue) {
            cur.add(curValue);
            target = target - curValue;
            helper(candidates, target, cur, res, index + 1);
        }
        cur.subList(size, cur.size()).clear();
    }
}