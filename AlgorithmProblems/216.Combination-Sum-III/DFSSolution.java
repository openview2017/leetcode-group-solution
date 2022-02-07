class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(k, n, cur, res, 1);
        return res;
    }
    
    private void helper(int k, int n, List<Integer> cur, List<List<Integer>> res, int index) {
        if (cur.size() == k) {
            if (n == 0) {
                res.add(new ArrayList(cur));
            }
            return;
        }
        if (index == 10 || n < 0) {
            return;
        }
        
        cur.add(index);
        helper(k, n - index, cur, res, index + 1);
        cur.remove(cur.size() - 1);
        
        helper(k, n, cur, res, index + 1);
    }
}

/*
DFS
how many levels: there're 1 to 9, a total of 9 levels, each level is 1 or 2 or 3...or 9
what does each level mean: use or not to use the current level value

TC: O(2^9)
SC: O(9)

k ...when we have k elements in the cur list, then return

*/