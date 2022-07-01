/*
n = candidates.length;
how many levels: n leveles, each level is an element from input
for each level, pick or not pick this element

sort the input array, so same elements stay together.
When picking, if not pick a certain element, skip through the elements, next round will be a different element;
but if pick an element, we can continue to pick or not to puck

TC: O(2^n)
SC: O(n) for the call stack

*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, cur, res, 0);
        return res;
    }
    private void helper(int[] candidates, int target, List<Integer> cur, List<List<Integer>> res, int index) {

        // base case
        if (target == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        
        if (target < 0 || index >= candidates.length) {
            return;
        }
        
        // case 1: add the current element
        cur.add(candidates[index]);
        helper(candidates, target - candidates[index], cur, res, index + 1);
        cur.remove(cur.size() - 1); // cur list还原
        
        // case 2: not add the current element, also skip all same elements
        while (index + 1 < candidates.length && candidates[index + 1] == candidates[index]) { // 
            index++;
        }
        
        helper(candidates, target, cur, res, index + 1); //从不相等的index位置往下走
    }
}